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
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> userList = new ArrayList<>();

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
        if (roleName.equals(RoleEnum.valueOf(roleName).toString())) {
            this.roleName = roleName;
        } else {
            this.roleName = null;
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
