package ru.levelup.musicians.library.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Setter
@Getter
@Builder
@ToString

public class Deposit {

    private int id;
    private String name;
    private double rate;
    private boolean canPartialRemoval;
    private boolean canReplenishment;
    private double amount;

}
