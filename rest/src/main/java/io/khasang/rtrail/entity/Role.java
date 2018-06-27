package io.khasang.rtrail.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Roles maybe assigned to Users from Enum RoleEnum only
 * in other case Role sets to null
 *
 * @author Ilya Bogachev
 * @since 14.06.2018
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roleList")
    private List<User> userList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        if (role_name.equals(RoleEnum.valueOf(role_name).toString())) {
            this.role_name = role_name;
        } else {
            this.role_name = null;
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
