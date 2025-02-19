package dev.sandeep.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExpenseCreateRequestDTO {
    private String description;
    private double amount;
    private int expenseAddedById;
    private List<UserExpenseCreateRequestDTO> userExpenses;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getExpenseAddedById() {
        return expenseAddedById;
    }

    public void setExpenseAddedById(int expenseAddedById) {
        this.expenseAddedById = expenseAddedById;
    }

    public List<UserExpenseCreateRequestDTO> getUserExpenses() {
        return userExpenses;
    }

    public void setUserExpenses(List<UserExpenseCreateRequestDTO> userExpenses) {
        this.userExpenses = userExpenses;
    }
}
