package com.koarito.WebserviceProject.repository;

import com.koarito.WebserviceProject.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
}
