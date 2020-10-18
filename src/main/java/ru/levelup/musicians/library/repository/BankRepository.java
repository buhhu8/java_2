package ru.levelup.musicians.library.repository;

import ru.levelup.musicians.library.model.Bank;
import ru.levelup.musicians.library.model.Person;

import java.util.List;

public interface BankRepository {

    Bank createBank(String name);

    void addClient(Integer bankId, Person person);

    List<Bank> finaAllBanks();
}
