package com.alumoto.tours.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class UserForm {

    @NotBlank
    @Size(min = 1, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]+", message="すべて半角英数字で入力してください")
    String username;

    @NotBlank
    @Size(min = 5, max = 32)
    @Pattern(regexp = "[a-zA-Z0-9]+", message="すべて半角英数字で入力してください")
    String password;

}

    