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
@Table(name = "countries")
public class countries {
  @Id
  private Integer country_id;
  @Column(name = "country_name")
  private String country_name;

  @OneToMany
  @JoinColumn(name = "country_id")
  private List<Musicians> musicians;

  @OneToMany
  @JoinColumn(name = "country_id")
  private List<Bands> bands;


}
