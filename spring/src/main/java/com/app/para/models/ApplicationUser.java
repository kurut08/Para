package com.app.para.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
@NamedQuery(name = ApplicationUser.FIND_BY_VERIFICATION_CODE, query = "SELECT u FROM ApplicationUser u WHERE u.verificationCode = :code")
public class ApplicationUser implements UserDetails{

    public static final String FIND_BY_VERIFICATION_CODE = "ApplicationUser.findByVerificationCode";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userId;
    @Column(unique=true)
    private String email;
    private String username;
    private String password;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    private boolean enabled;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="user_role_junction",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> authorities;

    public ApplicationUser() {
        super();
        authorities = new HashSet<>();
    }


    public ApplicationUser(Integer userId, String email, String username, String password, Set<Role> authorities) {
        super();
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setId(Integer userId) {
        this.userId = userId;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /* If you want account locking capabilities create variables and ways to set them for the methods below */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean b) {
        this.enabled=b;
    }

    public String getEmail() {
        return email;
    }

    public void setVerificationCode(String randomCode) {
        this.verificationCode=randomCode;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }
}