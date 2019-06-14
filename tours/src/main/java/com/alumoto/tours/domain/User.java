package com.alumoto.tours.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = "tours")
public class User {

    @Id
    private String userName;

    @JsonIgnore
    private String encodedPassword;

}