package edu.hacettepe.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COFFEEPRODUCT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany
    private Set<Order> items;

    public Product(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Product(){}

    public Product(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Order> getItems() {
        return items;
    }

    public void setItems(Set<Order> items) {
        this.items = items;
    }
}
