package ru.levelup.musicians.library.repository;

import ru.levelup.musicians.library.model.Deposit;

public interface DepositRepository {

    Deposit createDeposit(String name, double rate, boolean canPartialRemoval, boolean canReplenishment, double minAmount);

}
