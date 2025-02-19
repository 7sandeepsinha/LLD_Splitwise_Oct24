package dev.sandeep.Splitwise.service;

import dev.sandeep.Splitwise.dto.SettleUpTransactionResponseDTO;
import dev.sandeep.Splitwise.model.Group;

public interface SettleUpStrategy {
    SettleUpTransactionResponseDTO settleUp(Group group);
}
