package dev.sandeep.Splitwise.service;

import dev.sandeep.Splitwise.dto.SettleUpTransactionResponseDTO;
import dev.sandeep.Splitwise.model.*;

import java.util.HashMap;
import java.util.List;

public class MinimumTransactionSettleUpStrategy implements SettleUpStrategy {

    @Override
    public SettleUpTransactionResponseDTO settleUp(Group group) {
        HashMap<User, Integer> finalAmountPerUser = new HashMap<>();
        List<Expense> expenses = group.getExpenses();
        for(Expense expense : expenses) {
            for(UserExpense userExpense : expense.getUserExpenses()) {
                if(finalAmountPerUser.containsKey(userExpense.getUser())) {
                    int currentAmount = finalAmountPerUser.get(userExpense.getUser());
                    if(userExpense.getExpenseType().equals(UserExpenseType.HAS_PAID)){
                        currentAmount += userExpense.getAmount();
                    } else {
                        currentAmount -= userExpense.getAmount();
                    }
                    finalAmountPerUser.put(userExpense.getUser(), currentAmount);
                } else {
                    int currentAmount = 0;
                    if(userExpense.getExpenseType().equals(UserExpenseType.HAS_PAID)){
                        currentAmount += userExpense.getAmount();
                    } else {
                        currentAmount -= userExpense.getAmount();
                    }
                    finalAmountPerUser.put(userExpense.getUser(), currentAmount);
                }
            }
        }

        // output - <
        //          ["A" -> "B" : 50],
        //          ["C" -> "D" : 5500]
        //          >
        return null;

    }
}
