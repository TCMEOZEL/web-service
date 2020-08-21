package mainapp.service;

import mainapp.coffeeserv.CoffeeServ;
import mainapp.coffeeserv.CustomerService;
import mainapp.products.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mainapp.products.CoffeesEntity;

import java.util.List;

@RestController
public class Service1 {



    @Autowired
    private CoffeeServ coffees;

    @Autowired
    private CustomerService cust;

    @PostMapping("/add")
    public CoffeesEntity addCoffee(@RequestBody CoffeesEntity coffee){
        return coffees.newCoffee(coffee);
    }

    @GetMapping("/all")
    public List<CoffeesEntity> all(){
        return coffees.CoffeesToSell();
    }

    @GetMapping("/coffee/{id}")
    public CoffeesEntity coffeeType(@PathVariable(value="id") Integer coffeeid){
        return coffees.coffeeById(coffeeid);
    }

    @GetMapping("/coffees/{name}")
    public CoffeesEntity coffeeName(@PathVariable(value="name") String coffeename){
        return coffees.coffeeByName(coffeename);
    }

    @PutMapping("/sell/{id}")
    public CoffeesEntity sellCoffee(@PathVariable(value="id") Integer id) {
        return coffees.coffeeSold(id);
    }

    @PutMapping(value="/sellname")
    public ResponseEntity<String> sellByName(@RequestParam("CoffeeName") String coffee){
        CoffeesEntity saved = coffees.coffeeSoldbyName(coffee);
        return new ResponseEntity<>(saved.getCoffeeName()+" was sold. ", HttpStatus.OK);
    }

    @PutMapping("/refund/{id}")
    public CoffeesEntity refundCoffee(@PathVariable(value="id") Integer id){
        return coffees.refund(id);
    }

    @PutMapping("/customer/buy")
    public ResponseEntity<String> CustomerBuy(@RequestParam("Customer name")String name, @RequestParam("Coffee Name")String coffee,@RequestParam("quantity") int quantity){
        Customer customer = cust.customerbyName(name);
        CoffeesEntity cof = coffees.coffeeByName(coffee);
        double temp=customer.getMoney()-quantity*cof.getPrice();
        if(temp>0){
            CoffeesEntity saved=coffees.coffeeSoldbyNameandQuantity(coffee,quantity);
            Customer c=cust.custAfterPurchase(customer,temp);
            return new ResponseEntity<>(saved.getCoffeeName()+" was sold to "+c.getName(),HttpStatus.OK);
        }else return new ResponseEntity<>("There is not enough money.",HttpStatus.OK);
    }
}
