package com.easylearn.usermicroservice.controllers;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PostMapping()
    public UserEntity createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }
    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
