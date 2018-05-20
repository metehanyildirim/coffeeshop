package edu.hacettepe.controllers;

import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.DAO.User;
import edu.hacettepe.services.OrderService;
import edu.hacettepe.services.ProductService;
import edu.hacettepe.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    ProductService productService;
    OrderService orderService;
    UserService userService;


    @ResponseBody
    @RequestMapping(value = "/newOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order newOrder(@RequestParam("productId") int productId,
                          @RequestParam("quantity") int quantity,
                          @RequestParam("userId") int userId){
        Order order = null;
        try{
            User user = userService.getUser(userId);
            Product product = productService.find(productId);
            order = new Order(product , user, quantity);
            orderService.add(order);
        }catch (IOException e){
            e.printStackTrace();
        }
        return order;
    }

    @ResponseBody
    @RequestMapping(value = "/getHistory/{userId}")
    public List<Order> getUserHistory(@PathVariable("userId") int userId){
        List<Order> orderList = null;
        try{
            orderList = orderService.list(userId);
        }catch (IOException e){
            e.printStackTrace();
        }
        return orderList;
    }


    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
