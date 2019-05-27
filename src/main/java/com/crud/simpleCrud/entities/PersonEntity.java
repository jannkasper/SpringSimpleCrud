package com.crud.simpleCrud.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "personDB")
@Entity
public class PersonEntity extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
