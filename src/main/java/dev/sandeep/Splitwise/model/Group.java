package dev.sandeep.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private List<Expense> expenses; //ISSUE record of money spent -> who paid how much, and who owes how much
    @OneToMany
    private List<Transaction> transactions; //ISSUE who needs to pay whom, to clear all debts[Settle UP]
    private boolean isAllSettlementDone;
}


/*
        Group - User -> Owner [M:1]
        Group - User -> Member [M:M]
 */