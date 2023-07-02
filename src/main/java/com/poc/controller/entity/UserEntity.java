package com.poc.controller.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserEntity extends PanacheEntityBase {

    @Id
    public UUID id;
    @Column
    public String name;
    @Column
    public String age;
    @Column
    public String address;
    @Column
    public long creationDate;
}
