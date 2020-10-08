package ru.levelup.musicians.library.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
@ToString
public class Person {

    @Id
    private Integer id;
    private String name;
    @Column(name = "last_name",nullable = false, length = 100)
    private String lastName;
    @Column(name = "middle_name", length = 100)
    private String middleName;
    @Column(name = "born_date")
    private LocalDate bornDate;

}
