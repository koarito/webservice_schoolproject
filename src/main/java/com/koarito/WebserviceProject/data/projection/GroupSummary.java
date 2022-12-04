package com.koarito.WebserviceProject.data.projection;

import java.util.Set;

public interface GroupSummary {
    long getId();
    String getName();
    SimpleUser getGroupAdmin();
    Set<SimpleUser> getGroupMembers();

    interface SimpleUser{
        long getId();
        String getName();
    }
}
