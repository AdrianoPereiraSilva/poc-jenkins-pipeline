package com.poc.controller;

import com.poc.controller.dto.UserRequest;
import com.poc.controller.dto.UserResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Tag(name = "User")
@Path("/v1/users")
public interface UserApi {

    @POST
    void save(@RequestBody  UserRequest userRequest);

    @GET
    List<UserResponse> findAll();
}
