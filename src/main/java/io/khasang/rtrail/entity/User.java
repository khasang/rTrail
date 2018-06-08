package io.khasang.rtrail.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity Users to reflect user's fields:
 * username (for login)
 * password (to login)
 * email for send notification (verification code) and contact user
 * active the state of user account
 * activation code - send via email to activation of user account
 *
 * @author Ilya Bogachev
 * @since 08.06.2018
 */

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private String activationCode;

    public User() {
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set <Role> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}