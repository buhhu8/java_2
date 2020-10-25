package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

@AllArgsConstructor
@ToString
@Table(name = "Musicians")
public class Musicians {
    @Id
    private Integer id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "date_of_birth")
    private Date date_of_birth;
    @Column(name = "country_id")
    private Integer country_id;

    @ManyToMany
    @JoinTable(
            name ="musicians_genres",
            joinColumns = @JoinColumn(name = "musician_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genres> musicianGenres;

    @ManyToMany
    @JoinTable(
            name ="musician_albums",
            joinColumns = @JoinColumn(name = "musician_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List<Albums> musiciansAlbums;

    @OneToMany(mappedBy = "musician")
    private List<MusiciansBand> band;

    public Musicians(){
        this.musicianGenres =new ArrayList<>();
    }


//    @Override
//    public String toString() {
//
//        return "Musicians{" +
//                "id=" + id +
//                ", firstName='" + first_name + '\'' +
//                ", middleName='" + middle_name + '\'' +
//                ", lastName='" + last_name + '\'' +
//                ", Sex='" + sex + '\'' +
//                ", Date of Birth='" + date_of_birth + '\'' +
//                ", country id'" + country_id + '\'' +
//                ", Genres='" + getMusicianGenres().toString() + '\'' +
//                '}';
//    }


//    @OneToMany(mappedBy = "musicians")
//    private List<MusiciansBand> musiciansBand;

}
