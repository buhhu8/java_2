package ru.levelup.musicians.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_id")
    private String id;

    @Column(columnDefinition = "NUMERIC(19,2)")
    private double balance;

    @Column(name = "open_date")
    private LocalDateTime openDate;

    // @ManyToOne
    // @JoinColumn(name = "person_id")
    // private Person person;  Не забыть добавить mappedBy в аннотации @OneToMany в классе Person

}
