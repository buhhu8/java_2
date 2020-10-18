package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @ManyToMany(mappedBy = "musicians")
    private List<Genres> musicianGenres;

//    @OneToMany(mappedBy = "musicians")
//    private List<MusiciansBand> musiciansBand;

}
