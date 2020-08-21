package mainapp.repository;

import mainapp.products.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customer_rep extends JpaRepository<Customer,Integer> {
    Customer findByName(String name);
}
