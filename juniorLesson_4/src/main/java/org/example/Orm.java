package org.example;

import org.example.dataBaseConnection.Connector;
import org.example.dataBaseConnection.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class Orm {

    public void connectionSQL() {
        Session session = new Connector().getSession();
        Person person = new Person("Petr", "Petrov");
        session.beginTransaction();
        //session.save(person);
        // Фиксируем транзакцию
        //session.getTransaction().commit();
        // Закрываем сессию и фабрику
        session.close();

        try (Session session2 = HibernateUtil.getSession()) {
            // Создаем таблицу для сущности Person
            Person person2 = new Person("Person2", "Petrov");
            session2.beginTransaction();
            //session2.save(person2);
            // Фиксируем транзакцию
            //session2.getTransaction().commit();

            String query = "SELECT p FROM juniorlesson4.person_table";
            printProduct(session2, query);

            // Закрываем сессию и фабрику
            session2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printProduct(Session session, String query) {
        List<Person> list = session.createQuery(query, Person.class).list();
        for (Person pro : list) {
            System.out.println(pro.toString());
        }
    }


}
