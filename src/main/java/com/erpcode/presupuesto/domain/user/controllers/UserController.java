package com.erpcode.presupuesto.domain.user.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erpcode.presupuesto.domain.user.entity.User;
import com.erpcode.presupuesto.domain.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/data/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.allUsers(),HttpStatus.OK);
    }
}