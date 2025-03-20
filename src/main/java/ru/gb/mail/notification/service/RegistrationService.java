package ru.gb.mail.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gb.user.model.User;
import ru.gb.user.repository.UserRepository;
@Service
@RequiredArgsConstructor

public class RegistrationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public void register(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userRepository.save(user);
    }

    public void checkEmailExists(User user) {
        if (userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            throw new RuntimeException();
        }
    }
}
