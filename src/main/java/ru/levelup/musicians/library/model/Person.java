package ru.levelup.musicians.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")

public class Person {

    @Id
    private Integer id;
    private String name;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Column(name = "middle_name", length = 100)
    private String middleName;
    @Column(name = "born_date")
    private LocalDate bornDate;

    // person.getLegalInfo().getPerson()
    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY) // нужно указать поле из класса PersonLegalInfo, которое имеет тип Person
    private PersonLegalInfo legalInfo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private List<Account> accounts;

    @OneToMany(mappedBy = "person")
    private List<UserDeposits> deposits;

    @ManyToMany
    @JoinTable(
            name ="bank_persons",
            joinColumns = @JoinColumn(name = "person_id"), //имя колонки ищ таблицы bank_persons, которая яв-ся внешним ключом на текущую таблицу на Persons
            inverseJoinColumns = @JoinColumn(name = "bank_id")
    )
    private List<Bank> banks;

}
