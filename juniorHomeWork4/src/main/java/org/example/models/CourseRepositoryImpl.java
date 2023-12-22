package org.example.models;

import org.example.Course;
import org.example.dataBaseConnection.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public void add(Course course) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Course retrievedcourse) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(retrievedcourse);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course retrievedcourse) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(retrievedcourse);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            return session.get(Course.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Query<Course> query = session.createQuery("FROM " + Course.class.getSimpleName(), Course.class);
            List<Course> courses = query.list();
            session.getTransaction().commit();
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
