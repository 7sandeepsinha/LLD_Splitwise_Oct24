package dev.sandeep.Splitwise.controller;

import dev.sandeep.Splitwise.dto.GroupCreateRequestDTO;
import dev.sandeep.Splitwise.dto.SettleUpTransactionResponseDTO;
import dev.sandeep.Splitwise.model.Group;
import dev.sandeep.Splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity createGroup(@RequestBody GroupCreateRequestDTO requestDTO) {
        return ResponseEntity.ok(groupService.createGroup(requestDTO));
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") int id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @GetMapping("/group/{groupId}/settle")
    public ResponseEntity<SettleUpTransactionResponseDTO> settleGroup(@PathVariable("groupId") int groupId) {
        return ResponseEntity.ok(groupService.settleUp(groupId));
    }
}
