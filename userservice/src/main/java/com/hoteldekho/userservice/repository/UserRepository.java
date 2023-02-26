package com.hoteldekho.userservice.repository;

import com.hoteldekho.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
