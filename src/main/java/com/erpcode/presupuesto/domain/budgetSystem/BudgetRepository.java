package com.erpcode.presupuesto.domain.budgetSystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.erpcode.presupuesto.domain.budgetSystem.entities.Budget;

import java.util.Optional;

public interface BudgetRepository extends MongoRepository<Budget, ObjectId> {
    Optional<Budget> findByIdN(String idN);
    Void deleteByIdN(String idN);
}
