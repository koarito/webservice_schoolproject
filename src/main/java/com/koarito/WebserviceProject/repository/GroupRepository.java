package com.koarito.WebserviceProject.repository;

import com.koarito.WebserviceProject.data.domain.Group;
import com.koarito.WebserviceProject.data.domain.User;
import com.koarito.WebserviceProject.data.projection.GroupSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public interface GroupRepository extends JpaRepository<Group, Long> {
    Set<GroupSummary> getGroupsByGroupMembersContaining(User user);
}
