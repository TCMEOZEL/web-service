package mainapp.coffeeserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import mainapp.products.CoffeesEntity;
import mainapp.repository.coffee_rep;

import java.util.*;

@Service
public class CoffeeServ {
    public CoffeeServ(){}

    @Autowired
    private coffee_rep coffee;
    
    public List<CoffeesEntity> CoffeesToSell(){
        List<CoffeesEntity> toSell = new ArrayList<>();
        for (CoffeesEntity coffeesEntity : coffee.findAll()) {
            if (coffeesEntity.getCoffeeAmount() > 0)
                toSell.add(coffeesEntity);
        }
        return toSell;
           }

    public CoffeesEntity coffeeById(Integer id){
        return coffee.findById(id).orElse(null);
    }
    public CoffeesEntity coffeeSold(Integer id)  {
        CoffeesEntity cof= coffee.findById(id).orElse(null);
        if(cof.getCoffeeAmount()>0)
        cof.setCoffeeAmount(cof.getCoffeeAmount()-1);

        return coffee.save(cof);
    }

    public CoffeesEntity refund(Integer id){
        CoffeesEntity co = coffee.findById(id).orElse(null);
        co.setCoffeeAmount(co.getCoffeeAmount()+1);
        return coffee.save(co);
    }

    public CoffeesEntity newCoffee(CoffeesEntity cof){
        return coffee.save(cof);
    }

    public CoffeesEntity coffeeByName(String coffeeName){
        return coffee.findByCoffeeName(coffeeName);
    }

    public CoffeesEntity coffeeSoldbyName(String name)  {
        CoffeesEntity cof= coffee.findByCoffeeName(name);
        if(cof.getCoffeeAmount()>0)
            cof.setCoffeeAmount(cof.getCoffeeAmount()-1);

        return coffee.save(cof);
    }

    public CoffeesEntity coffeeSoldbyNameandQuantity(String name,int quantity)  {
        CoffeesEntity cof= coffee.findByCoffeeName(name);
        if(cof.getCoffeeAmount()>0)
            cof.setCoffeeAmount(cof.getCoffeeAmount()-quantity);

        return coffee.save(cof);
    }


}
