package com.poc.controller.mapper;

import com.poc.controller.dto.UserRequest;
import com.poc.controller.dto.UserResponse;
import com.poc.controller.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface UserMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "creationDate", expression = "java(new java.util.Date().getTime())")
    UserEntity toEntity(final UserRequest userRequest);

    List<UserResponse> toListUserResponse(List<UserEntity> userEntities);
}
