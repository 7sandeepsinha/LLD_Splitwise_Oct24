package dev.sandeep.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GroupCreateRequestDTO {
    private String name;
    private int createdById;
    private List<Integer> userIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}
