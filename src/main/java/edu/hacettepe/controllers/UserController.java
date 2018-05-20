package edu.hacettepe.controllers;

import edu.hacettepe.DAO.User;
import edu.hacettepe.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerSend(){
        return new ModelAndView("register");
    }


    @ResponseBody
    @RequestMapping(value = "/add")
    public User add(@ModelAttribute("user") User user){
        User ouruser = null;
        try{
            ouruser = userService.addUser(
                    user);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ouruser;
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public User delete(@RequestParam("id") int id){
        User user = null;
        try{
            user = userService.deleteUser(id);
        }catch (IOException e){
            e.printStackTrace();
        }
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<User> list(Principal principal){
        List<User> users = new ArrayList<User>();
        try {
            users = userService.listUsers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public User update(@ModelAttribute("user") User user, Principal principal){
        try{
            userService.updateUser(user);
        }catch (IOException e){
            e.printStackTrace();
        }
        return user;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
