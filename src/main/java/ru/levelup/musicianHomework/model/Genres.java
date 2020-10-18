package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

@Table(name = "genres")
public class Genres {

    @Id
    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany
    @JoinTable(
            name ="musicians_genres",
            joinColumns = @JoinColumn(name = "genre_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "musician_id")
    )
    private List<Musicians> musicians;

    public Genres(){
        this.musicians =new ArrayList<>();
    }

}
