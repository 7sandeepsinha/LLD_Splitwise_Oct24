package dev.sandeep.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private double amount;
    @ManyToOne
    private User addedBy; // expense owner - who added the expense
    @OneToMany
    private List<UserExpense> userExpenses; //ISSUE
}


/*
       Two entries need to be maintained -
       1. PaidBy -> <A,100>, <B,100>, <C,200>, <D,200>
       2. OwedBy -> <A,150>, <B,150>, <C,250>, <D,50>
    Expense - User -> added the expense [Expense:User :: M:1]
    Expense - User -> members of the expense[M:M]


    {
        "description": "Dinner",
        "amount" : 600,
        "addedBy: "A",
        "userExpenses" : {
            {A, 100, HAS_PAID}
            {B, 100, HAS_PAID}
            {C, 200, HAS_PAID}
            {D, 200, HAS_PAID}
            {A, 150, HAD_TO_PAY}
            {B, 150, HAD_TO_PAY}
            {C, 250, HAD_TO_PAY}
            {D, 50, HAD_TO_PAY}
        }
    }

    Expense - UserExpense :: 1:M
 */