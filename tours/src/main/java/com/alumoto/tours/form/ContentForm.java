package com.alumoto.tours.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContentForm {

    @NotNull
    private Integer contentType;


    @Size(min = 1, max = 200)
    private String contentDescription;

    @NotNull
    @Size(min = 1, max = 21844)
    private String contentDetail;

    @NotNull
    private int spotId;
}
    