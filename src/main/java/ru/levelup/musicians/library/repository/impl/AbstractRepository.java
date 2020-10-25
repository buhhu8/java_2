package ru.levelup.musicians.library.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
public class AbstractRepository {

    protected final SessionFactory factory;

    protected void runInTransaction(Consumer<Session> consumer) {
        Transaction tx = null;

        try(Session session = factory.openSession()){
            tx = session.beginTransaction();

            consumer.accept(session);

            tx.commit();
        } catch ( Exception exc) {
            if (tx!= null){
                System.out.println("Rollback transaction");
                tx.rollback();
            }
        }

    }

    //Function interface
    protected <T> T runInTransaction(Function<Session,T> function)  {
        Transaction tx = null;

        try(Session session = factory.openSession()){
            tx = session.beginTransaction();

            T result = function.apply(session);

            tx.commit();

            return result;
        } catch ( Exception exc) {
            if (tx!= null){
                System.out.println("Rollback transaction");
                tx.rollback();
            }
            throw new RuntimeException(exc);
        }
    }

    protected <T> T runWithoutTransaction(Function<Session, T> function){
        try(Session session = factory.openSession()){
            return function.apply(session);
        }
    }


}
