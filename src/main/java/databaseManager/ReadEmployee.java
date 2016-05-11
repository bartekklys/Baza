package databaseManager;

import java.util.ArrayList;
import java.util.List;

import UI.MainWindow;
import entities.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;


public class ReadEmployee {

    public void readEmployee(JTextArea area) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Query query = session.createQuery("from Employee");
        List<Employee> employees = query.list();
        area.append("==================================================================================================" + "\n");
        for (Employee e : employees) {
                area.append(e.toString());
        }
        session.getTransaction().commit();
        session.close();
    }
}
