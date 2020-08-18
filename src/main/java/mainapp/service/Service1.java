package mainapp.service;

import mainapp.coffeeserv.CoffeeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mainapp.products.CoffeesEntity;

import java.util.List;

@RestController
public class Service1 {

    @Autowired
    private CoffeeServ coffees;

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
    @PutMapping("/sell/{cid}")
    public CoffeesEntity sellCoffee(@PathVariable(value="cid") Integer id) {
        return coffees.coffeeSold(id);
    }
    @PutMapping("/refund/{vid}")
    public CoffeesEntity refundCoffee(@PathVariable(value="vid") Integer id){
        return coffees.refund(id);
    }
}
