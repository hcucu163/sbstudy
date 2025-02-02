package com.blackmyth.learning.sbstudy.controller;

import com.blackmyth.learning.sbstudy.model.User;
import com.blackmyth.learning.sbstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// @Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    
    // @RequestMapping(value = "/user0", method = RequestMethod.GET)
    @GetMapping(value = "/user0")
    public String getUsers() {
        return userService.getAllUsers().get(0).toString();
    }
    
    
    // public void setUserService(UserService userService) {
    //     this.userService = userService;
    // }
    //    public UserController(UserService userService) {
    //        this.userService = userService;
    //    }

    //    @RequestMapping(value="/user{id}", method = RequestMethod.GET)
    //    public User findUserById(Integer id) {
    //        return userService.findUserById(id);
    //    }

    //    生成一个方法findUserbyId, 返回一个User, 当页面地址是/user/{id}时，会调用findUserbyId方法
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findUserbyId(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
//        return userService.getUserById(id).get().toString();
    }

    @RequestMapping(value = "/testusers", method = RequestMethod.GET)
    public String getAllUsers(Model modelUsers) { //  public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        modelUsers.addAttribute("users", users);
        return "users";
        //        StringBuffer sb = new StringBuffer();
        ////        sb.append();
        //        for (User user : users) {
        //            sb.append(user.toString());
        //        }
        //        return sb.toString();
    }

    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() { //  public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        //convert users to json string
        //return users.toString();
        // System.out.println(users);
        return users;
        // modelUsers.addAttribute("users", users);
        // return "users";
        //        StringBuffer sb = new StringBuffer();
        // //        sb.append();
        //        for (User user : users) {
        //            sb.append(user.toString());
        //        }
        //        return sb.toString();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public void addUser() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("cucu_" + i);
            user.setAddress(String.valueOf(i * 100));
            userService.saveUser(user);
        }
    }

}