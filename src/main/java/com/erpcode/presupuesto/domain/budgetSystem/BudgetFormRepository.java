package com.erpcode.presupuesto.domain.budgetSystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.erpcode.presupuesto.domain.budgetSystem.entities.BudgetForm;

import java.util.Optional;

public interface BudgetFormRepository extends MongoRepository<BudgetForm, ObjectId> {
    Optional<BudgetForm> findByIdN(String idN);
    Void deleteByIdN(String idN);
}
