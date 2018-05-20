package edu.hacettepe.services;

import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.repository.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {
    private Repository repository;

    // This function deletes a product and returns its id.
    public void delete(int id) throws IOException
    {
        repository.deleteOrder(id);
    }

    public Order find(int id) throws IOException
    {
        return repository.findOrder(id);
    }

    public void add(Order order) throws IOException{
        repository.createOrder(order);
    }

    public Order updateOrderStatus(int id, String status) throws IOException{
        return repository.updateOrderStatus(id, status);
    }

    public List<Order> list(int userId) throws IOException{
        List<Order> orders = repository.listOrders();
        for(Iterator<Order> iterator = orders.iterator(); iterator.hasNext();){
            Order order = iterator.next();
            if(order.getOrderer().getId() != userId)
                iterator.remove();
        }
        return orders;
    }

    public List<Order> list() throws IOException{
        return repository.listOrders();
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
