package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "band_genres")
public class BandGenres {

//    @ManyToOne
//    @MapsId("bandId")
//    private Bands bandId;
//
//    @ManyToOne
//    @MapsId("genreId")
//    private Genres genreId;
}
