package com.koarito.WebserviceProject.data.request;

import lombok.Getter;

@Getter
public class CreateGroupRequest {
    private String name;
    private long groupAdminId;
}
