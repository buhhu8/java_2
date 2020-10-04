package ru.levelup.musicians.library.jdbc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class countries {
  private Integer country_id;
  private String country_name;
}
