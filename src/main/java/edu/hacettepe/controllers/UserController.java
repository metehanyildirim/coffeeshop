package edu.hacettepe.controllers;

import edu.hacettepe.DAO.User;
import edu.hacettepe.services.UserService;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/add")
    public ResponseEntity add(@RequestBody User user){
        User ouruser = null;
        try{
            ouruser = userService.addUser(
                    user);
        }catch (IOException e){
            e.printStackTrace();
        }
        if(ouruser == null){
            return ResponseEntity.ok().body("{\"msg\":\"User failed to add.\"}");
        } else {
            return ResponseEntity.ok().body(ouruser);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public ResponseEntity get(@RequestBody User user){
        User ouruser = null;
        try{
            ouruser = userService.getUser(user.getUsername());
        }catch (IOException e){
            e.printStackTrace();
        }

        if(ouruser != null && ouruser.getPassword().equals(user.getPassword())){
           return ResponseEntity.ok().body(ouruser);
        } else {
           return ResponseEntity.ok().body("{\"msg\":\"Wrong Credentials\"}");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        User user = null;
        try{
            user = userService.deleteUser(id);
        }catch (IOException e){
            e.printStackTrace();
        }
        if(user != null){
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.ok().body("{\"msg\":\"This user doesn't exist.\"}");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public ResponseEntity list(){
        List<User> users = null;
        try {
            users = userService.listUsers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if(users == null){
            return ResponseEntity.ok().body("{\"msg\":\"Users failed to list\"}");
        } else {
            return ResponseEntity.ok().body(users);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public ResponseEntity update(@RequestBody User user){
        try{
            userService.updateUser(user);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(user);
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
