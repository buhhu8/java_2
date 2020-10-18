package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "songs")
public class Songs {
    @Id
    @Column(name = "song_id")
    private Integer songId;
    @Column(name = "album_id")
    private Integer albumId;
    @Column(name = "song_name")
    private String songName;

}
