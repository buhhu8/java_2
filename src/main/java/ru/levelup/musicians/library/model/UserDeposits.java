package ru.levelup.musicians.library.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_deposits")
public class UserDeposits {

    @EmbeddedId
    private UserDepositId id;

    @ManyToOne
    @MapsId("person_id")
    private Person person;

    @ManyToOne
    @MapsId("deposit_id")
    private Deposit deposit;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(columnDefinition = "NUMERIC(19,0)")
    private Double amount;

    @Column(name = "end_date")
    private LocalDate endDate;

}
