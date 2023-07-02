package com.poc.controller;

import com.poc.controller.dto.UserRequest;
import com.poc.controller.dto.UserResponse;
import com.poc.controller.entity.UserEntity;
import com.poc.controller.mapper.UserMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;


@Path("/v1/users")
public class UserController implements UserApi {

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public void save(@RequestBody UserRequest user){

        UserEntity userEntity = userMapper.toEntity(user);

        userEntity.persist();
    }

    @Override
    public List<UserResponse> findAll(){
        List<UserEntity> userEntities = UserEntity.findAll().list();

        List<UserResponse> response = userMapper.toListUserResponse(userEntities);
        return response;
    }
}
