package com.alumoto.tours.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alumoto.tours.domain.User;
import com.alumoto.tours.domain.Spot;

@Entity
@Table(name = "contents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "content_content_id_seq")
    @SequenceGenerator(
        name = "content_content_id_seq",
        sequenceName = "content_content_id_seq",
        initialValue = 1,
        allocationSize = 1)
    private Integer contentId;

    @NotNull
    @Column(nullable = false)
    private Integer contentType;
    /*
    Content Type
    1 : Text
    2 : Image
    3 : Video
    4 : Music/Voice
    5 : Quiz
    */


    @Size(min = 1, max = 200)
    private String contentDescription;

    @NotNull
    private int contentNo;

    @NotNull
    @Size(min = 1, max = 21844)
    @Column(nullable = false)
    private String contentDetail;

    @ManyToOne
    private User creater;

    @ManyToOne
    private Spot parentSpot;
}