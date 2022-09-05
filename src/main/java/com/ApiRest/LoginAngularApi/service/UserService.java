package com.ApiRest.LoginAngularApi.service;

import com.ApiRest.LoginAngularApi.entity.RoleEntity;
import com.ApiRest.LoginAngularApi.entity.UserEntity;
import com.ApiRest.LoginAngularApi.repository.UserRepository;
import com.ApiRest.LoginAngularApi.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserService implements UserServiceRepository {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){

        this.userRepository=userRepository;

    }

    @Override
    public UserEntity saveEntity(UserEntity userEntity){
        UserEntity user = new UserEntity(
                userEntity.getName(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                passwordEncoder.encode(userEntity.getPassword()),
                userEntity.getLicense(),
                Arrays.asList(new RoleEntity(userEntity.getLicense()))
        );

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null){
            throw new UsernameNotFoundException(String.format("Not found enabled user for username", userEntity.getUsername()));
        }

        return new User(userEntity.getEmail(),userEntity.getPassword(), mapAutority(userEntity.getRoleEntity()));
    }

    private Collection<? extends GrantedAuthority> mapAutority(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }

}
