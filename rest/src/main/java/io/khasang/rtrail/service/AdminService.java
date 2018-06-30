package io.khasang.rtrail.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Admin service
 *
 * @author Sokolov Denis
 * @since 24.06.2018
 */
public interface AdminService {

    /**
     * method for getting authorized users
     *
     * @return authorized users
     */
    List<UserDetails> getAuthorizedUsers();

    /**
     * method for getting authorized users
     *
     * @param role - user's role for getting
     * @return authorized users by role
     */
    List<UserDetails> getAuthorizedUsersByRole(String role);

    /**
     * method for getting authorized users
     *
     * @param name - user's name for getting
     * @return authorized users by name
     */
    List<UserDetails> getAuthorizedUsersByName(String name);
}