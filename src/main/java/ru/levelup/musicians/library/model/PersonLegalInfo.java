package ru.levelup.musicians.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString(exclude = "person")
@NoArgsConstructor
@Table(name = "persons_legal_info")
public class PersonLegalInfo {

    @Id
    @Column(name = "person_id")
    private Integer personId;

    // fetch = LAZY - Hibernate сделает select, только когда мы обратимся к полю (к примеру, вызовем метод getPerson())
    @OneToOne(fetch = FetchType.LAZY) // <field_name>_id;
    // @JoinColumn(name = "person_id")
    @PrimaryKeyJoinColumn
    private Person person;

    @Column(name = "passport_series")
    private String passportSeries;
    @Column(name = "passport_number")
    private String passportNumber;
    private String inn;
    private String snils;

}
