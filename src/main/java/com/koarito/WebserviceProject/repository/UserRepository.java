package com.koarito.WebserviceProject.repository;

import com.koarito.WebserviceProject.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
