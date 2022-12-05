package com.koarito.WebserviceProject.data.request;

import lombok.Getter;

import java.util.Set;

@Getter
public class CreateGroupRequest {
    private String name;
    private long groupAdminId;
    private Set<Long> groupMembersId;
}
