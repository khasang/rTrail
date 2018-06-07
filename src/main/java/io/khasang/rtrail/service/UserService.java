package io.khasang.rtrail.service;


import io.khasang.rtrail.entity.User;

import java.util.List;

/**
 * interface for CRUD methods
 *
 * @author Ilya Bogachev
 * @since 06.06.2018
 */

public interface UserService {

    /**
     * method for add user
     *
     * @param user - new user for creation
     * @return created user
     */
    User addUser(User user);

    /**
     * method for update user
     *
     * @param user for update
     * @return updated user
     */
    User updateUser(User user);

    /**
     * method for getting user
     *
     * @param id - user's id for getting
     * @return user by id
     */
    User getUserById(long id);

    /**
     * method for getting a list of users with the given name
     *
     * @param username - requested users's name
     * @return list of users
     */

    List<User> getUserByName(String username);

    /**
     * method for remove user
     *
     * @param id - user's id
     * @return removed user
     */
    User deleteUser(long id);

    /**
     * method for getting all users
     *
     * @return a list of users
     */
    List<User> getAllUsers();
}
