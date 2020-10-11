package ru.levelup.musicianHomework.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class countries {
  @Id
  private Integer country_id;
  @Column(name = "country_name")
  private String country_name;
}
