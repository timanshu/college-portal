package com.collegeportal.user.controller;

import com.collegeportal.user.model.User;
import com.collegeportal.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id)
    {
        if(userService.userExists(id))
            return userService.getUser(id);

        throw new SecurityException("User does not exists");
    }

    @GetMapping("/")
    public List<User> getAllUser()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public int createNewUser(@RequestBody User user)
    {
        if(userService.userExists(user.getId()))
        {
            throw new SecurityException("Illegal access");
        }
        return userService.createNewUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        if(userService.userExists(id) || user.getId() != id)
            return userService.updateUser(user);

        throw new SecurityException("User does not exists");
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id)
    {
        if(userService.userExists(id))
        {
            userService.deleteUser(id);
            return;
        }
        throw new SecurityException("User does not exists");
    }
}
