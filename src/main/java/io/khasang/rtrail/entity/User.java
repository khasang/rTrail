package io.khasang.rtrail.entity;



import javax.persistence.*;

/**
 * Entity Users to reflect user's fields:
 * username (for login)
 * password (to login)
 * email for send notification (verification code) and contact user
 *
 * @author Ilya Bogachev
 * @since 06.08.2018
 */

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    private String username;
    private String password;
    private String email;

    public User() {
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}