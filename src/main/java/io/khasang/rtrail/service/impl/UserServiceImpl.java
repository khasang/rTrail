package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.UserDao;
import io.khasang.rtrail.entity.User;
import io.khasang.rtrail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service for UserService's interface CRUD methods
 * addressed realisation to userDao interface
 *
 * @author Ilya Bogachev
 * @since 06.06.2018
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.create(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public User deleteUser(long id) {
        User userForDelete = getUserById(id);
        return userDao.delete(userForDelete);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getList();
    }
}
