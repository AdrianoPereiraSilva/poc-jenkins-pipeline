package com.poc.controller.dto;

import io.smallrye.common.constraint.NotNull;

public class UserRequest {

    @NotNull
    public String name;

    @NotNull
    public String address;

    @NotNull
    public String age;
}
