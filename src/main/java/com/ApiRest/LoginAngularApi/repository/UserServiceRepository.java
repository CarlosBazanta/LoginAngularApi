package com.ApiRest.LoginAngularApi.repository;

import com.ApiRest.LoginAngularApi.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceRepository extends UserDetailsService {

    UserEntity saveEntity(UserEntity userEntity);

    List<UserEntity> userList();

}
