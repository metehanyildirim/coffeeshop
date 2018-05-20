package edu.hacettepe.repository;

import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.DAO.User;
import edu.hacettepe.controllers.ProductController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Repository
@Transactional
public class DBRepository implements Repository{

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Product getProduct(int id) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.load(Product.class, new Integer(id));
        return product;
    }

    @Override
    public List<Product> listProducts() throws  IOException {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").list();
        return products;
    }

    @Override
    public synchronized Product addProduct(Product product) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
        return product;
    }

    @Override
    public synchronized Product deleteProduct(int id) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.load(Product.class, new Integer(id));
        session.delete(product);
        return product;
    }

    @Override
    public synchronized void updateProduct(Product ourProduct) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        session.update(ourProduct);
    }

    @Override
    public User addUser(User user) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    @Override
    public List<User> listUsers() throws IOException {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User ").list();
        return users;
    }

    @Override
    public synchronized User deleteUser(int id) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.load(User.class, new Integer(id));
        session.delete(user);
        return user;
    }

    @Override
    public void updateUser(User user) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getUser(String username, String password) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").list();
        for(User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public Order findOrder(int id) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order)session.load(Order.class, new Integer(id));
        return order;
    }

    @Override
    public void createOrder(Order order) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
    }

    @Override
    public void deleteOrder(int id) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order)session.load(Order.class, new Integer(id));
        session.delete(order);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").list();
        for(User user: users){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public List<Order> listOrders() throws IOException{
        Session session = sessionFactory.getCurrentSession();
        List<Order> orders = session.createQuery("from Order").list();
        return orders;
    }

    @Override
    public Order updateOrderStatus(int id, String status) throws IOException{
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order)session.load(Order.class, new Integer(id));
        order.setStatus(status);
        session.update(order);
        return order;
    }

    @Override
    public User getUser(int id) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.load(User.class, new Integer(id));
        return user;
    }
}
