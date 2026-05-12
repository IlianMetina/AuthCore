package com.ilian.authcore.repositories;

import com.ilian.authcore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
