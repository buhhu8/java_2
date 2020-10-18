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
@ToString
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

}
