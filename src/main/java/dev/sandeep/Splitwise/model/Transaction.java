package dev.sandeep.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel{
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    private double amount;
}
