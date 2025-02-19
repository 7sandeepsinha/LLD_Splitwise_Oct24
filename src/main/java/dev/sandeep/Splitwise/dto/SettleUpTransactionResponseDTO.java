package dev.sandeep.Splitwise.dto;

import java.util.List;

public class SettleUpTransactionResponseDTO {
    private List<String> transactions;

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
}
