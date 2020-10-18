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

//    @OneToMany(mappedBy = "bands")
//    private List<MusiciansBand> bandsMusician;


}
