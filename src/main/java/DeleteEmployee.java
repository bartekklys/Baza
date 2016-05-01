import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteEmployee {

    public void deleteEmployee(int id){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = (Employee) session.load(Employee.class, id);

        session.delete(employee);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
