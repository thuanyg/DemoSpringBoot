package com.restfulapi.first_spring_boot.controller;

import com.restfulapi.first_spring_boot.dto.request.UserCreationRequest;
import com.restfulapi.first_spring_boot.dto.request.UserUpdateRequest;
import com.restfulapi.first_spring_boot.entity.User;
import com.restfulapi.first_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Tuong tac truc tiep voi service
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest user) {
        return userService.request(user);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers()    ;
    }

    @GetMapping("/{userid}")
    User getUserByID(@PathVariable String userid) {
        return userService.getUserByID(userid);
    }

    @PutMapping("/{userid}")
    User updateUser(@PathVariable String userid, @RequestBody UserUpdateRequest userUpdated) {
        return userService.updateUser(userid, userUpdated);
    }

    @DeleteMapping("/{userid}   ")
    String deleteUser(@PathVariable String userid) {
        return userService.deleteUser(userid);
    }
}
