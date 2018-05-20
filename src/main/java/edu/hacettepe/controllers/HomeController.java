package edu.hacettepe.controllers;

import edu.hacettepe.DAO.Order;
import edu.hacettepe.DAO.Product;
import edu.hacettepe.DAO.User;
import edu.hacettepe.services.OrderService;
import edu.hacettepe.services.ProductService;
import edu.hacettepe.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
public class HomeController {

    private OrderService orderService;
    private ProductService productService;
    private UserService userService;


    @ResponseBody
    @RequestMapping(value= "/",method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("customerIndex");
    }


    @ResponseBody
    @RequestMapping(value = "/jsp/updateCustomer", method = RequestMethod.GET)
    public ModelAndView updateCustomer(@RequestParam("id") int id){
        ModelAndView model = new ModelAndView("updateCustomer");
        try{
            User user = userService.getUser(id);
            model.addObject("user", user);
        }catch (IOException e){
            e.printStackTrace();
        }
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/jsp/coffee", method = RequestMethod.GET)
    public ModelAndView orderRedirect(@RequestParam("productId") int id){
        ModelAndView model = new ModelAndView("coffee");
        try{
            Product product = productService.find(id);
            model.addObject("product", product);
        }catch (IOException e){
            e.printStackTrace();
        }
        return model;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    public void setProductService(ProductService productService) {this.productService = productService;}
    public void setUserService(UserService userService) { this.userService = userService; }
}
