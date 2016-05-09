package DatabaseManager;

import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateEmployee {

    public void updateEmployee(int id, String name, String surname, int salary){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class, id);
        employee.setFirstName(name);
        employee.setLastName(surname);
        employee.setSalary(salary);

        session.getTransaction().commit();
        //sessionFactory.close();
        session.close();
    }
}
