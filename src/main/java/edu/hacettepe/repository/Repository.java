package edu.hacettepe.repository;

import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.DAO.User;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository {

    Product getProduct(int id) throws IOException;

    List<Product> listProducts() throws IOException;

    Product addProduct(Product product) throws IOException;

    Order findOrder(int id) throws IOException;

    Product deleteProduct(int id) throws IOException;

    public User getUser(String username) throws IOException;

    User getUser(int id) throws IOException;

    void updateProduct(Product product) throws IOException;

    User addUser(User user) throws IOException;

    List<User> listUsers() throws IOException;

    User deleteUser(int id) throws IOException;

    void updateUser(User user) throws IOException;

    User getUser(String username, String password) throws IOException;

    void createOrder(Order order) throws IOException;

    void deleteOrder(int id) throws IOException;

    List<Order> listOrders() throws IOException;

    public Order updateOrderStatus(int id, String status) throws IOException;
}
