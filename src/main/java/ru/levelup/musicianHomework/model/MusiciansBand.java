package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "musicians_bands")
public class MusiciansBand {

    @EmbeddedId
    private MusiciansBandsId id;

//    @ManyToOne
//    @MapsId("band_id")
//    private Bands bands;
//
//    @ManyToOne
//    @MapsId("musician_id")
//    private Musicians musicians.java;



    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
