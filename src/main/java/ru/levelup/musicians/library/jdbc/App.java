package ru.levelup.musicians.library.jdbc;

import ru.levelup.musicians.library.model.Deposit;

public class App {

    public static void main(String[] args) {
        DepositJdbcService depositJdbcService = new DepositJdbcService();
        // depositJdbcService.findAllDeposits();

        Deposit newDeposit = depositJdbcService.createNewDeposit(
                "Мечтай!", 9.87, true, true, 1000
        );
        System.out.println(newDeposit);
    }

}
