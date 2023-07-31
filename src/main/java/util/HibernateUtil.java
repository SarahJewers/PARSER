package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * The type Hibernate util.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
