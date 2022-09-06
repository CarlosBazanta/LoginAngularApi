package com.ApiRest.LoginAngularApi.controller;

import com.ApiRest.LoginAngularApi.repository.UserServiceRepository;
import com.ApiRest.LoginAngularApi.security.ExceptionSecurity;
import com.ApiRest.LoginAngularApi.entity.UserEntity;
import com.ApiRest.LoginAngularApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class AppController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceRepository userServiceRepository;

    @GetMapping("/user")
    public List<UserEntity> userList(){
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> idUser(@PathVariable long id ){

        UserEntity userEntity =userRepository.findById(id)
                .orElseThrow(()-> new ExceptionSecurity("Error Usuario de id:"+id+" no encontrado"));
        return ResponseEntity.ok(userEntity);

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity detailsUserEntity){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(()-> new ExceptionSecurity("Error Usuario de id:"+id+" no encontrado"));
        userEntity.setName(detailsUserEntity.getName());
        userEntity.setUsername(detailsUserEntity.getUsername());
        userEntity.setEmail(detailsUserEntity.getEmail());

        UserEntity updateUser = userRepository.save(userEntity);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(()-> new ExceptionSecurity("Error Usuario de id:"+id+" no encontrado"));

        userRepository.delete(userEntity);
        Map<String,Boolean> check = new HashMap<>();
        check.put("Delete",Boolean.TRUE);
        return ResponseEntity.ok(check);

    }

}
