package com.alumoto.tours.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SpotForm {

    @NotNull
    double spotLat;

    @NotNull
    double spotLng;

    @NotNull
    @Size(min = 1, max = 127)
    String spotName;

    @NotNull
    int tourId;
}
    