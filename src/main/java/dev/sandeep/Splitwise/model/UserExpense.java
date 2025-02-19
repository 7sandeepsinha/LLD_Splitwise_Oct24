package dev.sandeep.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType expenseType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(UserExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}

/*
    User : UserExpense :: 1:M
    UserExpense: User :: M:1
 */