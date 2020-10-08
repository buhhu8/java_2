package ru.levelup.musicians.library.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@Builder
@ToString
public class musicians {
    private Integer id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String sex;
    private Date date_of_birth;
    private Integer country_id;
}
