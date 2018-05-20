package edu.hacettepe.controllers;

import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.DAO.User;
import edu.hacettepe.services.OrderService;
import edu.hacettepe.services.ProductService;
import edu.hacettepe.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private ProductService productService;
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/newOrder")
    public Order newOrder(@RequestParam("productId") int productId,
                                 @RequestParam("quantity") int quantity, Principal principal){
        Order order = null;
        try{
            String username = principal.getName();
            User user = userService.getUser(username);
            Product product = productService.find(productId);
            order = new Order(product , user, quantity);
            orderService.add(order);
        }catch (IOException e){
            e.printStackTrace();
        }
        return order;
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Order> list(){
        List<Order> orders = null;
        try{
            orders = orderService.list();
        }catch (IOException e){
            e.printStackTrace();
        }
        return orders;
    }

    @ResponseBody
    @RequestMapping(value = "/setStatus")
    public Order setStatus(@RequestParam("id") int id){
        Order order = null;
        try{
            order = orderService.updateOrderStatus(id, "sent");
        }catch (IOException e){
            e.printStackTrace();
        }
        return order;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    public void setProductService(ProductService productService) {this.productService = productService;}
    public void setUserService(UserService userService) { this.userService = userService; }
}