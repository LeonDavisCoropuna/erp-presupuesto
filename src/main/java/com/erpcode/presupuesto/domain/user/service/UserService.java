package com.erpcode.presupuesto.domain.user.service;

import com.erpcode.presupuesto.domain.user.entity.*;
import com.erpcode.presupuesto.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> allUsers() {
        return userRepository.findAll();
    }
}