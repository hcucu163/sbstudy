package com.blackmyth.learning.sbstudy.controller;

import com.blackmyth.learning.sbstudy.model.User;
import com.blackmyth.learning.sbstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/user{id}", method = RequestMethod.GET)
    public User findUserById(Integer id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    public User saveUser(User user) {
        return userService.saveUser(user);
    }
}
