package org.example;

import org.example.dataBaseConnection.Connector;
import org.example.dataBaseConnection.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class Orm {

    public void connectionSQL() {

        Session session = new Connector().getSession();
        //savePersonToDataBase1(session);

        String query = "FROM Person";
        //printProduct(session, query);

        //findById(session, 1);

        deleteAll(session, query);

        //savePersonToDataBase2();

    }


    public void savePersonToDataBase1(Session session) {
        Person person = new Person("Petr", "Petrov");
        session.beginTransaction();
        session.save(person);
        // Фиксируем транзакцию
        session.getTransaction().commit();
        // Закрываем сессию и фабрику
        session.close();
    }

    public void savePersonToDataBase2() {
        try (Session session2 = HibernateUtil.getSession()) {
            // Создаем таблицу для сущности Person
            Person person2 = new Person("Person2", "Petrov");
            session2.beginTransaction();
            session2.save(person2);
            // Фиксируем транзакцию
            session2.getTransaction().commit();
            // Закрываем сессию и фабрику
            session2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printProduct(Session session, String query) {
        List<Person> list = session.createQuery(query, Person.class).getResultList();
        list.forEach(System.out::println);
    }

    private void findById(Session session, int id) {
        String hql = "FROM Person WHERE id = :id";
        Query<Person> query = session.createQuery(hql, Person.class);
        query.setParameter("id", id);
        Person person = query.getSingleResult();
        System.out.println(person);
        person.setFirstName("Denis");
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        System.out.println(person);
    }

    private void deleteAll(Session session, String query) {
        Transaction transaction = session.beginTransaction();
        List<Person> list = session.createQuery(query, Person.class).getResultList();
        list.forEach(session::delete);
        transaction.commit();
    }

}
