import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ParentDAO {
 public Parent findById(int id){
     return HibernateUtils.getSessionFactory().openSession().get(Parent.class,id);
 }
public void save(Parent parent){
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.save(parent);
    tx1.commit();
    session.close();
}
    public void update(Parent parent){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(parent);
        tx1.commit();
        session.close();
    }
    public void delete(Parent parent){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(parent);
        tx1.commit();
        session.close();
    }
    public Child findChildById(int id){
     return HibernateUtils.getSessionFactory().openSession().get(Child.class,id);
    }
public List<Parent> findAll(){
     List<Parent> parents = (List<Parent>) HibernateUtils.getSessionFactory().openSession().createQuery("From Parent").list();
     return parents;
}
}
