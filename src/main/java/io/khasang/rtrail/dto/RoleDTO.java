package io.khasang.rtrail.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for Roles required to transfer roles between View and Service
 *
 * @author Ilya Bogachev
 * @since 15.06.2018
 */
public class RoleDTO {
    private Long id;
    private String roleName;
    private List<UserDTO> userDTOList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }
}
