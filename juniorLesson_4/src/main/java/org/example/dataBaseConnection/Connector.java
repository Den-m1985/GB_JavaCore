package org.example.dataBaseConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connector {
    final StandardServiceRegistry registry;
    final SessionFactory sessionFactory;

    public Connector() {
        // Создаем стандартный реестр сервисов Hibernate
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public Session getSession() {
        // Открываем сессию Hibernate
        return sessionFactory.openSession();
    }

}
