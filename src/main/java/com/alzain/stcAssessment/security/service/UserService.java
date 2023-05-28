package com.alzain.stcAssessment.security.service;

import com.alzain.stcAssessment.entity.AppRole;
import com.alzain.stcAssessment.entity.ServiceUser;

import java.util.List;

public interface UserService {
    ServiceUser saveUser(ServiceUser user);

    AppRole saveRole(AppRole permission);

    void addRoleToUser(String userName, String role);

    ServiceUser getUser(String userName);

    List<ServiceUser> getUsers();
}
