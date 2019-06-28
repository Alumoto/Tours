package com.alumoto.tours.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "users")
@Data
@ToString(exclude = "spotList")
public class User  {

    @Id
    private String username;

    @JsonIgnore
    private String encodedPassword;

    @Column
    private Boolean enabled;

    @OneToMany(mappedBy = "createdUser")
    private List<Spot> spotList;

}