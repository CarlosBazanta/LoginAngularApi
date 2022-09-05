package com.ApiRest.LoginAngularApi.entity;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "user")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String license;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    private Collection<RoleEntity> roleEntity;

    public UserEntity() {
    }

    public UserEntity(String email, String username, String password, String name, String license, Collection<RoleEntity> roleEntity) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.license = license;
        this.roleEntity = roleEntity;
    }

    public UserEntity(long id, String email, String username, String password, String name, String license, Collection<RoleEntity> roleEntity) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.license = license;
        this.roleEntity = roleEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Collection<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(Collection<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }
}
