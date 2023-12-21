package com.erpcode.presupuesto.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashSet;

import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}