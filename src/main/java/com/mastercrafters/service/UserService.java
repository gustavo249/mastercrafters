package com.mastercrafters.service;

import com.mastercrafters.model.accounts.User;
import com.mastercrafters.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gustavo on 12/06/2016.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public User getUser(User user) {
        return userRepository.findOneByEmail(user.getEmail());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void delete(User user) {
        userRepository.delete(user.getId());
    }
}
