package mainapp.coffeeserv;

import org.springframework.beans.factory.annotation.Autowired;
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
        CoffeesEntity ce;
        for(Iterator iterator = coffee.findAll().iterator(); iterator.hasNext();){
            ce = (CoffeesEntity)iterator.next();
            if(ce.getCoffeeAmount()>0)
                toSell.add(ce);
        }
        return toSell;
           }

    public CoffeesEntity coffeeById(Integer id){
        return coffee.findById(id).orElse(null);
    }
    public CoffeesEntity coffeeSold(Integer id){
        CoffeesEntity cof= coffee.findById(id).orElse(null);
        Integer sold = cof.getCoffeeAmount();
        cof.setCoffeeAmount(sold);
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
}
