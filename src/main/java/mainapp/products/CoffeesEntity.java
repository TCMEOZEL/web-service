package mainapp.products;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "coffees", schema = "starbucks")
@EntityListeners(AuditingEntityListener.class)
public class CoffeesEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coffee_id")
    private int coffeeId;
    @Basic
    @Column(name = "coffee_name")
    private String coffeeName;
    @Basic
    @Column(name = "coffee_amount")
    private Integer coffeeAmount;
    @Basic
    @Column(name = "price")
    private Double price;

    public CoffeesEntity(){}


    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }


    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }


    public Integer getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setCoffeeAmount(Integer coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeesEntity that = (CoffeesEntity) o;

        if (coffeeId != that.coffeeId) return false;
        if (coffeeName != null ? !coffeeName.equals(that.coffeeName) : that.coffeeName != null) return false;
        if (coffeeAmount != null ? !coffeeAmount.equals(that.coffeeAmount) : that.coffeeAmount != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coffeeId;
        result = 31 * result + (coffeeName != null ? coffeeName.hashCode() : 0);
        result = 31 * result + (coffeeAmount != null ? coffeeAmount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
