package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.User;

import java.util.List;

/**
 * interface extends BasicDao with parameter User
 * contains method for getting users by name
 *
 * @author Ilya Bogachev
 * @since 06.08.2018
 */

public interface UserDao extends BasicDao<User> {
    /**
     * method for getting users by name
     *
     * @param username user's name as filter
     * @return a list of users
     */
    List<User> getByName(String username);

    /**
     * method for getting users by login
     *
     * @param login user's login as filter
     * @return list of users
     */
    List<User> getByLogin(String login);
}
