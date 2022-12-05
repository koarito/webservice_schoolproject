package com.koarito.WebserviceProject.Service;

import com.koarito.WebserviceProject.data.domain.Group;
import com.koarito.WebserviceProject.data.domain.User;
import com.koarito.WebserviceProject.data.request.CreateGroupRequest;
import com.koarito.WebserviceProject.repository.GroupRepository;
import com.koarito.WebserviceProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    public ResponseEntity<Long> createGroup(CreateGroupRequest newGroup){
        Group group = new Group();
        try{
            group.setName(newGroup.getName());
            group.setGroupAdmin(userRepository.getReferenceById(newGroup.getGroupAdminId()));
            if(newGroup.getGroupMembersId().size() != 0) {
                Set<User> convertedSet = new HashSet<>(userRepository.findAllById(newGroup.getGroupMembersId()));
                group.setGroupMembers(convertedSet);
            }
            return new ResponseEntity(groupRepository.save(group).getId(), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> addGroupMember(long groupId, long userId){
       try {
           Group group = groupRepository.findById(groupId).get();
           User user = userRepository.getReferenceById(userId);
           group.getGroupMembers().add(user);
           groupRepository.save(group);
           return new ResponseEntity<>("Member added to group", HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity<>("Wrong id inputs", HttpStatus.BAD_REQUEST);
       }

    }
}
