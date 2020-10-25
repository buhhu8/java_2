package ru.levelup.musicians.library.repository.impl;

import org.hibernate.Session;

public interface MethodInvocation {

    void process(Session session);
}
