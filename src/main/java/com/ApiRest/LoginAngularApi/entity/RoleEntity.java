package com.ApiRest.LoginAngularApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class RoleEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public RoleEntity() {
    }

    public RoleEntity(String authority) {
        this.authority = authority;
    }

    public RoleEntity(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }
}
