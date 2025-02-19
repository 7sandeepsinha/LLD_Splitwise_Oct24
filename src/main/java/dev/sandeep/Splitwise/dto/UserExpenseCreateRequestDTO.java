package dev.sandeep.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseCreateRequestDTO {
    private int userId;
    private double amount;
    private int expenseType; //HAS_PAID, // 1  ====   HAD_TO_PAY; // 2

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(int expenseType) {
        this.expenseType = expenseType;
    }
}
