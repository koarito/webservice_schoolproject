package com.koarito.WebserviceProject.data.request;

import com.koarito.WebserviceProject.data.enm.Role;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
