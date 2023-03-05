package com.Geekster.ToDo_Project.service;

import com.Geekster.ToDo_Project.dao.IUserRepo;
import com.Geekster.ToDo_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    public ResponseEntity addUser(User user) {
        userRepo.save(user);
        return new ResponseEntity<>("User is created successfully "+user.getName(), HttpStatus.CREATED);
    }
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    public User getUserById(Integer id){
        return userRepo.findById(id).get();
    }
    public ResponseEntity updateUser(Integer id,User userdetails){
        User user = userRepo.findById(id).get();
        user.setUserId(userdetails.getUserId());
        user.setName(userdetails.getName());
        user.setEmail(userdetails.getEmail());
        return new ResponseEntity<>("User has been updated successfully",HttpStatus.OK);
    }
    public ResponseEntity deleteUser(Integer id){
        User user = userRepo.findById(id).get();
        if(user==null){
            return new ResponseEntity("The User with the following id "+id+" is not present",HttpStatus.BAD_REQUEST);
        }
        userRepo.deleteById(id);
        return new ResponseEntity<>("User has been deleted successfully",HttpStatus.ACCEPTED);
    }
    public List<User> getUserByname(String name){
        return userRepo.findByName(name);
    }
    public List<User> getUserbyEmail(String email){
        return userRepo.findByEmail(email);
    }
}
