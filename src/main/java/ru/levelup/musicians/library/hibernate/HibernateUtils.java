package ru.levelup.musicians.library.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtils {

    private HibernateUtils() {}

    private static SessionFactory factory;

    static {
        Configuration configuration = new Configuration()
                .configure(); // << config file name
        factory = configuration.buildSessionFactory();

        // Configuration hbmConfiguration = new Configuration().configure("hbm.xml");
        // SessionFactory hbmFactory = hbmConfiguration.buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

}
