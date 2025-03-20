package ru.gb.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.security.TaskTrackerUserDetails;
import ru.gb.user.model.User;
import ru.gb.user.repository.UserRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByUserDetails(TaskTrackerUserDetails taskTrackerUserDetails){
        Long userId =taskTrackerUserDetails.getUser().getId();
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не существует"));
    }



}
