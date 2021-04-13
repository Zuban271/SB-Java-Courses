import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    static {

        try {
            Configuration config = new Configuration();
            sessionFactory = config.configure().buildSessionFactory();
            }
        catch (Throwable e){
            System.err.println("Error is creating SessionFactory object" + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }

        }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
