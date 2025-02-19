package dev.sandeep.Splitwise.service;

import dev.sandeep.Splitwise.dto.UserExpenseCreateRequestDTO;
import dev.sandeep.Splitwise.model.UserExpense;
import dev.sandeep.Splitwise.model.UserExpenseType;
import dev.sandeep.Splitwise.repository.UserExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExpenseService {
    @Autowired
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    private UserService userService;

    public UserExpense createUserExpense(UserExpenseCreateRequestDTO requestDTO) {
        UserExpense userExpense = new UserExpense();
        userExpense.setAmount(requestDTO.getAmount());
        userExpense.setUser(userService.findById(requestDTO.getUserId()));
        if(requestDTO.getExpenseType() == 1){
            userExpense.setExpenseType(UserExpenseType.HAS_PAID);
        } else {
            userExpense.setExpenseType(UserExpenseType.HAD_TO_PAY);
        }

        return userExpenseRepository.save(userExpense);
    }
}
