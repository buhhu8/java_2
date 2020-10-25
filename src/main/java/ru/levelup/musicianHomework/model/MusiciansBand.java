package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "musicians_bands")
public class MusiciansBand {

    @EmbeddedId
    private MusiciansBandsId id;


    @ManyToOne
    @MapsId("musicianId")
    @JoinColumn(name = "musician_id")
    private Musicians musician;


    @ManyToOne
    @MapsId("bandId")
    @JoinColumn(name = "band_id")
    private Bands band;



    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
