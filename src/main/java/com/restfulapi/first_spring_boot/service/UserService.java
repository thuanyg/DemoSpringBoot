package com.restfulapi.first_spring_boot.service;
import com.restfulapi.first_spring_boot.dto.request.UserCreationRequest;
import com.restfulapi.first_spring_boot.dto.request.UserUpdateRequest;
import com.restfulapi.first_spring_boot.entity.User;
import com.restfulapi.first_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User request(UserCreationRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public User getUserByID(String id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(String id, UserUpdateRequest request){
        User user = getUserByID(id);
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public String deleteUser(String id){
        userRepository.deleteById(id);
        return "User deleted";
    }
}
