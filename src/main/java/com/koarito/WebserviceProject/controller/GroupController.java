package com.koarito.WebserviceProject.controller;

import com.koarito.WebserviceProject.Service.GroupService;
import com.koarito.WebserviceProject.data.request.CreateGroupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/create")
    ResponseEntity<Long> createGroup(@RequestBody CreateGroupRequest newGroup){
        return groupService.createGroup(newGroup);
    }

    @PutMapping("/{groupId}/members/{userId}")
    ResponseEntity<String> addGroupMember(@PathVariable long groupId, @PathVariable long userId){
       return groupService.addGroupMember(groupId, userId);
    }
}
