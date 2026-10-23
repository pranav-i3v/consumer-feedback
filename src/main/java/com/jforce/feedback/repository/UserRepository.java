package com.jforce.feedback.repository;

import com.jforce.feedback.entity.JForceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JForceUser, Long> {
    Optional<JForceUser> findByUsername(String username);
    List<JForceUser> findByRole(String role);
}
