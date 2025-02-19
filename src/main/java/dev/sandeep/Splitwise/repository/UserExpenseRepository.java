package dev.sandeep.Splitwise.repository;

import dev.sandeep.Splitwise.model.User;
import dev.sandeep.Splitwise.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
