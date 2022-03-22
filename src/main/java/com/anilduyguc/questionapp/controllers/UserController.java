package com.anilduyguc.questionapp.controllers;

import com.anilduyguc.questionapp.entities.User;
import com.anilduyguc.questionapp.repos.UserRepository;
import com.anilduyguc.questionapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService ) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.getOneUserById(userId);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId, newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteOneUser(userId);
    }
}
