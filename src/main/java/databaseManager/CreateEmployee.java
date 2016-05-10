package databaseManager;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateEmployee {

    public void addEmployee(Employee employee) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
}