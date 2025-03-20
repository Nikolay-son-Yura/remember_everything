package ru.gb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.user.model.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByUserId(Long userId);
}
