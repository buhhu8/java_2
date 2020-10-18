package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "musician_albums")
public class MusicianAlbums {

//    @ManyToOne
//    @MapsId("musician_id")
//    private Musicians musicianId;
//
//    @ManyToOne
//    @MapsId("album_id")
//    private AlbumsRepository albumId;
}
