package ru.levelup.musicianHomework.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtils {

    private HibernateUtils(){}

    private static SessionFactory factory;

    static {
        Configuration configuration = new Configuration()
                .configure();

        factory = configuration.buildSessionFactory();
    }

    public static SessionFactory getFactory(){
        return factory;
    }

}
