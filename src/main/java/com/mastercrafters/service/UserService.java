package com.mastercrafters.service;

import com.mastercrafters.model.User;
import com.mastercrafters.model.dto.UserDTO;
import com.mastercrafters.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gustavo on 12/06/2016.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void create(UserDTO userDTO) {
        User user = new User();
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setTelephone(userDTO.getTelephone());
        user.setType(userDTO.getType());
        user.setUsername(userDTO.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userRepository.saveAndFlush(user);
    }

    public User getUser(User user) {
        return userRepository.findOneByUsername(user.getUsername());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void delete(User user) {
        userRepository.delete(user.getId());
    }
}
