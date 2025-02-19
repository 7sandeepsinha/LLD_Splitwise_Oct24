package dev.sandeep.Splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User createdBy;
    private double totalAmountSpend;
    @ManyToMany
    private List<User> members; // ISSUE
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses; //ISSUE:FIXED record of money spent -> who paid how much, and who owes how much
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Transaction> transactions; //ISSUE:FIXED who needs to pay whom, to clear all debts[Settle UP]
    private boolean isAllSettlementDone;

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setTotalAmountSpend(double totalAmountSpend) {
        this.totalAmountSpend = totalAmountSpend;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setAllSettlementDone(boolean allSettlementDone) {
        isAllSettlementDone = allSettlementDone;
    }

    public String getName() {
        return name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public double getTotalAmountSpend() {
        return totalAmountSpend;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean isAllSettlementDone() {
        return isAllSettlementDone;
    }
}


/*
        Group - User -> Owner [M:1]
        Group - User -> Member [M:M]
 */