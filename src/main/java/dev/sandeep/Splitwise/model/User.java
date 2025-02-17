package dev.sandeep.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    @ManyToMany
    private List<Group> groups;
}
