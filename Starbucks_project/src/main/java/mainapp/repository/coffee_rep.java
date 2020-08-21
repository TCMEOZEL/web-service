package mainapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mainapp.products.CoffeesEntity;

@Repository
public interface coffee_rep extends JpaRepository<CoffeesEntity,Integer> {
    CoffeesEntity findByCoffeeName(String coffeeName);
}
