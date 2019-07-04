package com.alumoto.tours.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@ToString(exclude = "spotList")
public class Tour  {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tour_tour_id_seq")
    @SequenceGenerator(
        name = "tour_tour_id_seq",
        sequenceName = "tour_tour_id_seq",
        initialValue = 1,
        allocationSize = 1)
    private Integer tourId;

    @NotNull
    private String tourName;

    @ManyToOne
    private User creator;

    @OneToMany(mappedBy = "parentTour")
    private List<Spot> spotList;
    
}