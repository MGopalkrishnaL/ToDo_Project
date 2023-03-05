package com.Geekster.ToDo_Project.controller;

import com.Geekster.ToDo_Project.model.User;
import com.Geekster.ToDo_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/createUser")
    public ResponseEntity saveUser(@RequestBody User user){
       return userService.addUser(user);
    }
    @GetMapping(value = "/getallUsers")
    public List<User> getall(){
        return userService.getUsers();
    }
    @GetMapping(value = "/getUser/{id}")
    public User getuser(@PathVariable Integer id){
        return userService.getUserById(id);
    }
    @DeleteMapping(value = "/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
    @PutMapping(value = "/updateUser/{id}")
    public ResponseEntity updateUser(@RequestBody User user , @PathVariable Integer id){
        return userService.updateUser(id,user);
    }
    @GetMapping(value = "/getUsersByName/{name}")
    public List<User> getByname(@PathVariable String name){
        return userService.getUserByname(name);
    }
    @GetMapping(value = "/getUsersByEmail/{email}")
    public List<User> getUserbyEmail(@PathVariable String email){
        return userService.getUserbyEmail(email);
    }
}
