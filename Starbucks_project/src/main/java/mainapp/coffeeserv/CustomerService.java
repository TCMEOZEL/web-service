package mainapp.coffeeserv;

import mainapp.products.Customer;
import mainapp.repository.customer_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private customer_rep cust;

    public Customer customerbyName(String name){
        return cust.findByName(name);
    }
    public Customer custAfterPurchase(Customer cus,double price){
        cus.setMoney(price);
        return cust.save(cus);
    }

}
