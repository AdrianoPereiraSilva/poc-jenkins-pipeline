package com.poc.controller.dto;

import io.smallrye.common.constraint.NotNull;

public class UserRequest {

    @NotNull
    public String name;
    public String address;
    public String age;
}
