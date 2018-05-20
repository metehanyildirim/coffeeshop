package edu.hacettepe.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COFFEEORDER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User orderer;
    private String status;

    public Order(){}

    public Order(int id, Product product, User orderer, int quantity){
        this.setId(id);
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setOrderer(orderer);
        this.setStatus("new");
    }

    public Order(Product product, User orderer, int quantity){
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setOrderer(orderer);
        this.setStatus("new");
    }

    public Product getProduct() {
        return product;
    }

    public User getOrderer() {
        return orderer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderer(User orderer) {
        this.orderer = orderer;
    }
}
