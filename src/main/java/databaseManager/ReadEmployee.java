package databaseManager;

import java.util.List;

import UI.MainWindow;
import entities.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ReadEmployee {

    public void readEmployee() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Query query = session.createQuery("from Employee");
        List<Employee> employees = query.list();
        for (Employee employee : employees) {
            //System.out.println(employee.toString());
        }
        session.getTransaction().commit();
        session.close();
    }
}
