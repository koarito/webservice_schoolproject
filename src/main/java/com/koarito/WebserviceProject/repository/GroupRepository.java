package com.koarito.WebserviceProject.repository;

import com.koarito.WebserviceProject.data.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
