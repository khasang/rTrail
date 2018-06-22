package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.Role;
import io.khasang.rtrail.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User DTO contains methods for parsing Role list from User
 * connect View and Service
 *
 * @author Ilya Bogachev
 * @since 22.06.2018
 */
@Component
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<RoleDTO> roleDTOList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoleDTOList(List<RoleDTO> roleDTOList) {
        this.roleDTOList = roleDTOList;
    }

    public List<RoleDTO> getRoleDTOList() {
        return roleDTOList;
    }

    public List<UserDTO> getUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            List<RoleDTO> roleDTOList = new ArrayList<>();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            getRoleDTOListFromUser(user, roleDTOList);
            userDTO.setRoleDTOList(roleDTOList);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public UserDTO getUserDTO(User user) {
            List<RoleDTO> roleDTOList = new ArrayList<>();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            getRoleDTOListFromUser(user, roleDTOList);
            userDTO.setRoleDTOList(roleDTOList);
        return userDTO;
    }

    /**
     * parsing Roles from User Entity to Role DTO list
     *
     * @param user - for getting Roles
     * @param roleDTOList for adding Roles from user
     */
    private void getRoleDTOListFromUser(User user, List<RoleDTO> roleDTOList) {
        for (Role role : user.getRoleList()) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setRoleName(role.getRoleName());
            roleDTOList.add(roleDTO);
        }
    }
}
