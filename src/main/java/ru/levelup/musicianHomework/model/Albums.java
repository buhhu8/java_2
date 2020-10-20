package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "albums")
public class Albums {

    @Id
    @Column(name = "album_id")
    private Integer album_id;
    @Column(name = "album_name")
    private String album_name;
    @Column(name = "album_year")
    private LocalDate album_year;

    @OneToMany
    @JoinColumn(name = "album_id")
    List <Songs> songs;

    @ManyToMany
    @JoinTable(
            name ="musician_albums",
            joinColumns = @JoinColumn(name = "album_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "musician_id")
    )
    private List<Musicians> albumMusicians;


    @ManyToMany
    @JoinTable(
            name ="band_albums",
            joinColumns = @JoinColumn(name = "album_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "band_id")
    )
    private List<Bands> albumsBands;

}
