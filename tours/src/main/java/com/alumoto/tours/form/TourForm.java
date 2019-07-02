package com.alumoto.tours.form;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TourForm {

    @NotNull
    @Size(min = 1, max = 30)
    String tourName;
}
    