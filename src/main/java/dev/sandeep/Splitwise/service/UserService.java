package dev.sandeep.Splitwise.service;

import dev.sandeep.Splitwise.exception.UserNotFoundException;
import dev.sandeep.Splitwise.model.User;
import dev.sandeep.Splitwise.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found")
        );
    }
}
