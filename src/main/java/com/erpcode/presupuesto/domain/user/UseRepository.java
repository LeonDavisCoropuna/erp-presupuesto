package com.erpcode.presupuesto.domain.user;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.erpcode.presupuesto.domain.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}