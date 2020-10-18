package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "band_albums")
public class BandAlbums {

//    @ManyToOne
//    @MapsId("band_id")
//    private Bands bandId;
//
//    @ManyToOne
//    @MapsId("album_id")
//    private AlbumsRepository albumId;
}
