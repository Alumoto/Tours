package com.alumoto.tours.domain;


import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "users")
@Data
//@ToString(exclude = "tours")
public class User  {

    @Id
    private String username;

    @JsonIgnore
    private String encodedPassword;

    @Column
    private Boolean enabled;

}