package com.koarito.WebserviceProject.controller;

import com.koarito.WebserviceProject.Service.UserService;
import com.koarito.WebserviceProject.data.projection.GroupSummary;
import com.koarito.WebserviceProject.data.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    ResponseEntity<Long> createUser(@RequestBody CreateUserRequest newUser){
        return userService.createUser(newUser);
    }

    @GetMapping("/groups")
    ResponseEntity<Set<GroupSummary>> getUsersGroups(@RequestParam long userId){
        return userService.getUsersTeams(userId);
    }

    @DeleteMapping("/delete")
    void deleteUser(@RequestParam long userId){
        userService.deleteUser(userId);
    }
}
