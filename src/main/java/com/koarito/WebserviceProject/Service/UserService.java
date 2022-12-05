package com.koarito.WebserviceProject.Service;

import com.koarito.WebserviceProject.data.domain.User;
import com.koarito.WebserviceProject.data.projection.GroupSummary;
import com.koarito.WebserviceProject.data.request.CreateUserRequest;
import com.koarito.WebserviceProject.repository.GroupRepository;
import com.koarito.WebserviceProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    public ResponseEntity<Long> createUser(CreateUserRequest newUser){
        User user = new User();
        try{
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setRole(newUser.getRole());
            return new ResponseEntity<>(userRepository.save(user).getId(), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Set<GroupSummary>> getUsersTeams(long id){
        try{
            return new ResponseEntity<>(groupRepository.getGroupsByGroupMembersContaining(userRepository.getReferenceById(id)), HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> deleteUser(long id){
        try{
            userRepository.deleteById(id);
            return new ResponseEntity("User deleted", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
