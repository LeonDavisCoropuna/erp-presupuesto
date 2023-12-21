package com.erpcode.presupuesto.domain.budgetSystem.services;

import com.erpcode.presupuesto.api.commons.BudgetMapping;
import com.erpcode.presupuesto.domain.budgetSystem.BudgetRepository;
import com.erpcode.presupuesto.domain.budgetSystem.entities.Budget;
import com.erpcode.presupuesto.domain.budgetSystem.payloads.BudgetResponse;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    private final BudgetMapping budgetMapping;

    public BudgetService(BudgetRepository budgetRepository, BudgetMapping budgetMapping) {
        this.budgetRepository = budgetRepository;
        this.budgetMapping = budgetMapping;
    }

    public List<Budget> allBudget()
    {
        return budgetRepository.findAll();
    }

    public Budget BudgetById(String idN)
    {
        try {
            return budgetRepository.findByIdN(idN).orElse(null);
        } catch (NoSuchElementException e) {
            return null; // Opcionalmente, puedes lanzar una excepción personalizada o registrar un error aquí.
        }

    }

    public String createBudget(Budget budget) {
        try {
            budgetRepository.save(budget);
            return "OK";
        } catch (Exception e) {
            return e.getCause().toString();
        }
    }
    public String updateBudget(String idN, BudgetResponse budgetResponse) {
        try {
            Optional<Budget> budgetData = budgetRepository.findByIdN(idN);
            if(budgetData.isPresent()){
                Budget _budget = budgetData.get();
                budgetMapping.updateBudgetByResponse(budgetResponse,_budget);
                budgetRepository.save(_budget);
                return "OK";
            }
            return "NOT_FOUND";
        }catch (Exception e) {
            return e.getCause().toString();
        }
    }
    public void deleteByIdN(String idN)
    {
        budgetRepository.deleteByIdN(idN);
    }
}
