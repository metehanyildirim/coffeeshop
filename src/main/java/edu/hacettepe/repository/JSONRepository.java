package edu.hacettepe.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.DAO.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Repository
public class JSONRepository implements Repository{
    ObjectMapper mapper = new ObjectMapper();
    final private File usersFile = new File("usersFile.json");
    final private File productsFile = new File("productsFile.json");
    final private File ordersFile = new File("ordersFile.json");

    public JSONRepository(){
        if(!usersFile.exists()) {
            try{
                mapper.writeValue(usersFile, new ArrayList<User>());
                mapper.writeValue(productsFile, new ArrayList<Product>());
                mapper.writeValue(ordersFile, new ArrayList<Product>());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Product getProduct(int id) throws IOException {
        ArrayList<Product> products = mapper.readValue(productsFile, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        for(Product product : products){
            if(product.getId() == id)
                return product;
        }
        return null;
    }

    @Override
    public List<Product> listProducts() throws  IOException {
        ArrayList<Product> products = mapper.readValue(productsFile, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        return products;
    }

    @Override
    public synchronized Product addProduct(Product product) throws IOException {
        ArrayList<Product> products = mapper.readValue(productsFile, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        int id = products.size();
        products.add(new Product(id, product.getName()));
        mapper.writeValue(productsFile, products);
        return new Product(id, product.getName());
    }

    @Override
    public synchronized Product deleteProduct(int id) throws IOException {
        ArrayList<Product> products = mapper.readValue(productsFile, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        Product ourproduct = null;
        for(Iterator<Product> iterator = products.iterator(); iterator.hasNext();){
            Product product = iterator.next();
            if(product.getId() == id) {
                ourproduct = product;
                iterator.remove();
            }
        }
        mapper.writeValue(productsFile, products);
        return ourproduct;
    }

    @Override
    public synchronized void updateProduct(Product ourProduct) throws IOException {
        ArrayList<Product> products = mapper.readValue(productsFile, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        products.set(ourProduct.getId(), ourProduct);
        mapper.writeValue(productsFile, products);
    }

    @Override
    public User addUser(User user) throws IOException {
        ArrayList<User> users =  mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        int id = users.size();
        users.add(new User(id, user.getUsername(), user.getPassword(),
                    user.getName(), user.getSurname(), user.getRole(), user.getAddress()));
        mapper.writeValue(usersFile, users);
        return new User(id, user.getUsername(), user.getPassword(),
                user.getName(), user.getSurname(), user.getRole(), user.getAddress());
    }

    @Override
    public List<User> listUsers() throws IOException {
        ArrayList<User> users =  mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        return users;
    }

    @Override
    public synchronized User deleteUser(int id) throws IOException{
        ArrayList<User> users = mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        User ouruser = null;
        for(Iterator<User> iterator = users.iterator(); iterator.hasNext();){
            User user = iterator.next();
            if(user.getId() == id) {
                ouruser = user;
                iterator.remove();
            }
        }
        mapper.writeValue(usersFile, users);
        return ouruser;
    }

    @Override
    public void updateUser(User user) throws IOException{
        ArrayList<User> users = mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        users.set(user.getId(), user);
        mapper.writeValue(usersFile, users);
    }

    @Override
    public User getUser(String username, String password) throws IOException{
        ArrayList<User> users = mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        for(User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    @Override
    public User getUser(String username) throws IOException{
        ArrayList<User> users = mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        for(User user: users){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public Order findOrder(int id) throws IOException{
        ArrayList<Order> orders = mapper.readValue(ordersFile, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        for(Order order : orders){
            if(order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public void createOrder(Order order) throws IOException{
        ArrayList<Order> orders = mapper.readValue(ordersFile, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));
        int orderSize = orders.size();
        orders.add(new Order(orderSize, order.getProduct(), order.getOrderer(), order.getQuantity()));
        mapper.writeValue(ordersFile, orders);
    }

    @Override
    public void deleteOrder(int id) throws IOException{
        ArrayList<Order> orders = mapper.readValue(ordersFile, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));
        for(Order order : orders){
            if(order.getId() == id)
                orders.remove(order);
        }
        mapper.writeValue(ordersFile, orders);
    }

    public List<Order> listOrders() throws IOException{
        List<Order> orders = mapper.readValue(ordersFile, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));
        return orders;
    }

    public Order updateOrderStatus(int id, String status) throws IOException{
        ArrayList<Order> orders = mapper.readValue(ordersFile, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));
        Order ourOrder = null;
        for(Order order : orders){
            if(id == order.getId()){
                order.setStatus(status);
                ourOrder = order;
            }
        }
        mapper.writeValue(ordersFile, orders);
        return ourOrder;
    }

    public User getUser(int id) throws IOException {
        ArrayList<User> users = mapper.readValue(usersFile, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        for(User user: users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

}
