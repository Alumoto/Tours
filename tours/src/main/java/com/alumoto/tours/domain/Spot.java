package com.alumoto.tours.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "spot_spot_id_seq")
    @SequenceGenerator(
        name = "spot_spot_id_seq",
        sequenceName = "spot_spot_id_seq",
        initialValue = 1,
        allocationSize = 1)
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

    @NotNull
    private int spotNo;

    @ManyToOne
    //@JoinColumn(nullable = true, name = "username")
    private User creator;

    @ManyToOne
    private Tour parentTour;
}