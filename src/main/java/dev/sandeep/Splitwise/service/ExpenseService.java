package dev.sandeep.Splitwise.service;

import dev.sandeep.Splitwise.dto.ExpenseCreateRequestDTO;
import dev.sandeep.Splitwise.dto.UserExpenseCreateRequestDTO;
import dev.sandeep.Splitwise.model.Expense;
import dev.sandeep.Splitwise.model.UserExpense;
import dev.sandeep.Splitwise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserExpenseService userExpenseService;
    @Autowired
    private GroupService groupService;

    public Expense createExpense(ExpenseCreateRequestDTO requestDTO, int groupId){
        Expense expense = new Expense();
        expense.setAmount(requestDTO.getAmount());
        expense.setDescription(requestDTO.getDescription());
        expense.setAddedBy(userService.findById(requestDTO.getExpenseAddedById()));
        List<UserExpense> userExpenses = new ArrayList<>();
        for(UserExpenseCreateRequestDTO dto : requestDTO.getUserExpenses()){
            userExpenses.add(userExpenseService.createUserExpense(dto));
        }
        expense.setUserExpenses(userExpenses);
        Expense savedExpense = expenseRepository.save(expense);
        groupService.addExpenseToGroup(expense, groupId);
        return savedExpense;
    }
}
