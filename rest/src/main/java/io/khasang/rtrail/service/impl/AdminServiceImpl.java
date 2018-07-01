package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SessionRegistry sessionRegistry;
    @Autowired(required = false)
    private GrantedAuthorityDefaults grantedAuthorityDefaults;

    @Override
    public List<UserDetails> getAuthorizedUsers() {
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<UserDetails> authorizedUsers = new ArrayList<>();

        for (Object principal : principals) {
            if (principal instanceof UserDetails) {
                final UserDetails userDetails = (UserDetails) principal;
                authorizedUsers.add(userDetails);
            }
        }

        return authorizedUsers;
    }

    @Override
    public List<UserDetails> getAuthorizedUsersByRole(String role) {
        List<UserDetails> authorizedUsersByRole = new ArrayList<>();
        List<UserDetails> authorizedUsers = getAuthorizedUsers();

        for (UserDetails authorizedUser : authorizedUsers) {
            if (hasRole(authorizedUser, role)) {
                authorizedUsersByRole.add(authorizedUser);
            }
        }

        return authorizedUsersByRole;
    }

    @Override
    public List<UserDetails> getAuthorizedUsersByName(String name) {
        List<UserDetails> authorizedUsersByName = new ArrayList<>();
        List<UserDetails> authorizedUsers = getAuthorizedUsers();

        for (UserDetails authorizedUser : authorizedUsers) {
            if (name.equals(authorizedUser.getUsername())) {
                authorizedUsersByName.add(authorizedUser);
            }
        }

        return authorizedUsersByName;
    }

    @Override
    public int getNumberOnlineUsers() {
        return getAuthorizedUsers().size();
    }

    private boolean hasRole(UserDetails userDetails, String role) {
        String rolePrefix = grantedAuthorityDefaults != null ? grantedAuthorityDefaults.getRolePrefix() : "ROLE_";
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(rolePrefix + role);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        return authorities.contains(simpleGrantedAuthority);
    }
}