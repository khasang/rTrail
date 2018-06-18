package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.UserDao;
import io.khasang.rtrail.dto.UserDTO;
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
 * @since 16.06.2018
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDTO userDTO;

    @Override
    public UserDTO addUser(User user) {
        return userDTO.getUserDTO(userDao.create(user));
    }

    @Override
    public UserDTO updateUser(User user) {
        return userDTO.getUserDTO(userDao.update(user));
    }

    @Override
    public UserDTO getUserById(long id) {
        return userDTO.getUserDTO(userDao.getById(id));
    }

    @Override
    public List<UserDTO> getUserByName(String name) {
        return userDTO.getUserDTOList(userDao.getByName(name));
    }

    @Override
    public UserDTO deleteUser(long id) {
        return userDTO.getUserDTO(userDao.delete(userDao.getById(id)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userDTO.getUserDTOList(userDao.getList());
    }
}
