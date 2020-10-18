package ru.levelup.musicianHomework.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "musicians_genres")
public class MusicianGenres {
    @Id
    private Integer musician_id;
    private Integer genre_id;
}
