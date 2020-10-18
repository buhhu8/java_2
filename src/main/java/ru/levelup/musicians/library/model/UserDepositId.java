package ru.levelup.musicians.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserDepositId implements Serializable {

    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "deposit_id")
    private Integer depositId;
}
