package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.UserDao;
import io.khasang.rtrail.dto.UserDTO;
import io.khasang.rtrail.entity.User;
import io.khasang.rtrail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service for UserService's interface CRUD methods
 * addressed realisation to userDao interface
 * contains password encoder to save sensitive information
 *
 * @author Ilya Bogachev
 * @since 22.06.2018
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDTO userDTO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDTO.getUserDTO(userDao.create(user));
    }

    @Override
    public UserDTO updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
