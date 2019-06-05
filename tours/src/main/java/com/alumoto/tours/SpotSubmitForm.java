package com.alumoto.tours;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class SpotSubmitForm {

    @NotNull
    double spotLatitude;

    @NotNull
    double spotLongitude;

    @NotNull
    String spotName;
}
    