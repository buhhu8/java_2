package ru.levelup.musicians.library.model;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "banks")
    private List<Person> bankPersons;

    public Bank(){
        this.bankPersons = new ArrayList<>();
    }

    public Bank(String name){
        this.name = name;
    }
}
