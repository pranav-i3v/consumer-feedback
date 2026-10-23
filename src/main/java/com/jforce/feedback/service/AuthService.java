package com.jforce.feedback.service;

import com.jforce.feedback.entity.JForceUser;
import com.jforce.feedback.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<JForceUser> authenticateUser(String username, String password) {
        return userRepository.findByUsername(username).filter(user -> user.getPassword().equals(password));
    }

    public Optional<JForceUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void createJForceUser(String username, String email, String password) {

        JForceUser user = new JForceUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("USER");

        userRepository.save(user);

    }
}
