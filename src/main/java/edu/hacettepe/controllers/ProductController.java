package edu.hacettepe.controllers;

import edu.hacettepe.DAO.Product;
import edu.hacettepe.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private ProductService productService;


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Product add(@RequestParam("name") String name)
    {
        Product product = null;
        try{
            product = productService.add(new Product(name));
        } catch (IOException e){
            e.printStackTrace();
        }
        return product;
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Product get(@RequestParam("id") int id)
    {
        Product product = null;
        try{
            product = productService.find(id);
        }catch (IOException e){
            e.printStackTrace();
        }
        return product;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Product delete(@RequestParam("id") int id)
    {
        Product product = null;
        try{
            product = productService.delete(id);
        } catch (IOException e){
            e.printStackTrace();
        }
        return product;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Product> list()
    {
        List<Product> products = null;
        try{
            products = productService.list();
        }catch (IOException e){
            e.printStackTrace();
        }
        return products;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Product update(@RequestParam("id") int id ,
                               @RequestParam("name") String name)
    {
        try{
            productService.update(new Product(id, name));
        } catch(IOException e){
            e.printStackTrace();
        }
        return new Product(id, name);
    }

    public void setProductService(ProductService productService)
    {
        this.productService = productService;
    }
}
