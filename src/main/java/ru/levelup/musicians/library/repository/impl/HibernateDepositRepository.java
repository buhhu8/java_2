package ru.levelup.musicians.library.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.model.Deposit;
import ru.levelup.musicians.library.repository.DepositRepository;

@RequiredArgsConstructor
public class HibernateDepositRepository implements DepositRepository {

    private final SessionFactory factory;

    // public HibernateDepositRepository(SessionFactory factory) { this.factory = factory; }

    @Override
    public Deposit createDeposit(String name, double rate, boolean canPartialRemoval, boolean canReplenishment, double minAmount) {
        //ACID
        //A - атомарность - все операции выполнились или откатились
        //C - согласованность данных - нельзя фиксировать изменения которые не удовлетворятют constraint
        //I - isolation (уровни изолированности транзакций)
        //D - durability - если commit выполнился, то данные находятся в базе
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            Deposit deposit = new Deposit();
            deposit.setName(name);
            deposit.setRate(rate);
            deposit.setCanPartialRemoval(canPartialRemoval);
            deposit.setCanReplenishment(canReplenishment);
            deposit.setAmount(minAmount);

            session.persist(deposit); // << void persist(object); -> object.id = <generated id>

            System.out.println("Generated deposit ID: " + deposit.getId());

            tx.commit();  //фиксирует все изменения которые были сделаны

            return deposit;
        } catch (Exception exc){
            if(tx != null){
                tx.rollback(); //откат всех изменений до начала транзакции
            }
            throw new RuntimeException(exc);
        }
    }

}
