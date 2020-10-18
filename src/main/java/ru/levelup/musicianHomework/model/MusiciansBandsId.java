package ru.levelup.musicianHomework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MusiciansBandsId implements Serializable {

        @Column(name = "musician_id")
        private Integer musicianId;
        @Column(name = "band_id")
        private Integer bandId;

}
