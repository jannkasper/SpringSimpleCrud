package com.crud.simpleCrud.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Table(name = "personDB")
@Entity
public class PersonEntity extends BaseEntity {

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "name")
    @NotEmpty
    @Size(min=2,max=15)
    private String name;

    @Column(name = "age")
    @Min(16)
    private Integer age;
}
