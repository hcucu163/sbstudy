package com.blackmyth.learning.sbstudy.service;

import com.blackmyth.learning.sbstudy.model.User;
import com.blackmyth.learning.sbstudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // public UserService(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

//    @RequestMapping(value="/user{id}", method = RequestMethod.GET)
//    public User findUserById(Integer id) {
//        Optional<User> user = userRepository.findById(id);
//        return user.orElse(null);
////        return userRepository.findById(id).get();
//    }

    // @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

