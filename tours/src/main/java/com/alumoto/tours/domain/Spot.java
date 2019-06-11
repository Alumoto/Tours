package com.alumoto.tours.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "spots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spot {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer spotId;

    @NotNull
    @Column(nullable = false)
    private double spotLat;

    @NotNull
    @Column(nullable = false)
    private double spotLng;

    @NotNull
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String spotName;
}