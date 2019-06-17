package com.alumoto.tours.form;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class UserForm {

    @NotNull
    String userName;

    @NotNull
    String password;

}

    