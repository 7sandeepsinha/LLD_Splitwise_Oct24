package dev.sandeep.Splitwise.service;

import dev.sandeep.Splitwise.dto.GroupCreateRequestDTO;
import dev.sandeep.Splitwise.dto.SettleUpTransactionResponseDTO;
import dev.sandeep.Splitwise.exception.GroupNotFoundException;
import dev.sandeep.Splitwise.model.Expense;
import dev.sandeep.Splitwise.model.Group;
import dev.sandeep.Splitwise.model.User;
import dev.sandeep.Splitwise.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;

    public Group createGroup(GroupCreateRequestDTO groupCreateRequestDTO) {
        Group group = new Group();
        group.setName(groupCreateRequestDTO.getName());
        group.setTotalAmountSpend(0);
        group.setAllSettlementDone(false);

        User createdBy = userService.findById(groupCreateRequestDTO.getCreatedById());
        group.setCreatedBy(createdBy);

        List<User> members = new ArrayList<>();
        for(Integer id : groupCreateRequestDTO.getUserIds()){
            members.add(userService.findById(id));
        }
        group.setMembers(members);

        return groupRepository.save(group);
    }

    public Group getGroupById(Integer id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupNotFoundException("Group with id " + id + " not found")
        );
    }

    public Group addExpenseToGroup(Expense expense, int groupId){
        Group group = getGroupById(groupId);
        List<Expense> expenses = group.getExpenses();
        expenses.add(expense);
        group.setExpenses(expenses);
        return groupRepository.save(group);
    }

    public SettleUpTransactionResponseDTO settleUp(int groupId){
        return null;
    }
}
