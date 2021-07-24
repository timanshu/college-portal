package com.collegeportal.user.service;

import com.collegeportal.user.model.User;
import com.collegeportal.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(u ->{
            userList.add(u);
        });
        return userList;
    }

    public boolean userExists(int id) {
        return userRepository.findById(id).isPresent();
    }

    public int createNewUser(User user) {
        user = userRepository.save(user);
        return user.getId();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
