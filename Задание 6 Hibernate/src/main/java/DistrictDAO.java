import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DistrictDAO {
    public District findById(int id){
        return HibernateUtils.getSessionFactory().openSession().get(District.class,id);
    }
    public void save(District district){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(district);
        tx1.commit();
        session.close();
    }
    public void update(District district){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(district);
        tx1.commit();
        session.close();
    }
    public void delete(District district){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(district);
        tx1.commit();
        session.close();
    }

    public List<District> findAll(){
        List<District> districts = (List<District>) HibernateUtils.getSessionFactory().openSession().createQuery("From District").list();
        return districts;
    }
}


