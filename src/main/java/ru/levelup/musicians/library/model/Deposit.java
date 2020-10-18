package ru.levelup.musicians.library.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@Table(name = "deposits")
public class Deposit {

    @Id
    @SequenceGenerator(
            name = "deposit_id_seq_generator",
            sequenceName = "deposit_id_sequence", // должно совпадать с названием sequence, которое представлено в базе
            allocationSize = 3
    )
    @GeneratedValue(generator = "deposit_id_seq_generator", strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    @Column(columnDefinition = "NUMERIC(19,0)")
    private double rate;
    @Column(name = "can_partial_removal")
    private boolean canPartialRemoval;
    @Column(name = "can_replenishment")
    private boolean canReplenishment;
    @Column(name = "min_amount", columnDefinition = "NUMERIC(19,0)")
    private Double amount;

    @OneToMany(mappedBy = "deposit")
    private List<UserDeposits> deposits;

    public Deposit() {}

    @Builder
    public Deposit(int id, String name, double rate, boolean canPartialRemoval, boolean canReplenishment, double amount) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.canPartialRemoval = canPartialRemoval;
        this.canReplenishment = canReplenishment;
        this.amount = amount;
    }

}
