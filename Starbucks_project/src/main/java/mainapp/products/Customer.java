package mainapp.products;

import javax.persistence.*;

@Entity
@Table(name="customer",schema="starbucks")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="money")
    private double money;

    public int getId() {
        return this.id;
    }

    public double getMoney() {
        return this.money;
    }
    public String getName(){
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}
