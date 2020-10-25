package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "bands")

public class Bands {
    @Id
    @Column(name = "band_id")
    private Integer bandId;

    @Column(name = "band_name")
    private String bandName;

    @Column(name = "years_active")
    private String yearsActive;

    @Column(name = "country_id")
    private Integer countryId;
    @ManyToMany
    @JoinTable(
            name ="bands_genres",
            joinColumns = @JoinColumn(name = "band_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genres> bandsGenres;


    @ManyToMany
    @JoinTable(
            name ="band_albums",
            joinColumns = @JoinColumn(name = "band_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List<Albums> bandsAlbums;


    @OneToMany(mappedBy = "band")
    private List<MusiciansBand> musician;


}
