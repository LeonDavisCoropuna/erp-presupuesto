package com.erpcode.presupuesto.domain.user;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.erpcode.presupuesto.domain.user.entity.ERole;
import com.erpcode.presupuesto.domain.user.entity.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
        Optional<Role> findByName(ERole name);
}