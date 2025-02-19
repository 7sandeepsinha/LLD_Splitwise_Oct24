package dev.sandeep.Splitwise.controller;

import dev.sandeep.Splitwise.dto.ExpenseCreateRequestDTO;
import dev.sandeep.Splitwise.model.Expense;
import dev.sandeep.Splitwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expense/{groupId}")
    public ResponseEntity<Expense> createExpenseInGroup(@RequestBody ExpenseCreateRequestDTO requestDTO, @PathVariable("groupId") int groupId){
        return ResponseEntity.ok(expenseService.createExpense(requestDTO, groupId));
    }
}
