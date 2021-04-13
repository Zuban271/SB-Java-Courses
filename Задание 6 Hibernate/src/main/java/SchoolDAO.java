import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SchoolDAO {
    public School findById(int id){
        return HibernateUtils.getSessionFactory().openSession().get(School.class,id);
    }
    public void save(School school){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(school);
        tx1.commit();
        session.close();
    }
    public void update(School school){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(school);
        tx1.commit();
        session.close();
    }
    public void delete(School school){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(school);
        tx1.commit();
        session.close();
    }

    public List<School> findAll(){
        List<School> schools = (List<School>) HibernateUtils.getSessionFactory().openSession().createQuery("From School").list();
        return schools;
    }
}

