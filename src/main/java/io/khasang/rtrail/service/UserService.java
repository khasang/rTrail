package io.khasang.rtrail.service;


import io.khasang.rtrail.dto.UserDTO;
import io.khasang.rtrail.entity.User;
import java.util.List;

/**
 * interface for CRUD methods
 *
 * @author Ilya Bogachev
 * @since 16.08.2018
 */
public interface UserService {

    /**
     * method for add user
     *
     * @param user - new user for creation
     * @return created user
     */
    UserDTO addUser(User user);

    /**
     * method for update user
     *
     * @param user for update
     * @return updated user
     */
    UserDTO updateUser(User user);

    /**
     * method for getting user
     *
     * @param id - user's id for getting
     * @return user by id
     */
    UserDTO getUserById(long id);

    /**
     * method for getting a list of users with the given name
     *
     * @param username - requested users's name
     * @return list of users
     */

    List<UserDTO> getUserByName(String username);

    /**
     * method for remove user
     *
     * @param id - user's id
     * @return removed user
     */
    UserDTO deleteUser(long id);

    /**
     * method for getting all users
     *
     * @return a list of users
     */
    List<UserDTO> getAllUsers();
}
