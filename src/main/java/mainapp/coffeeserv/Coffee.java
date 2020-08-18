package mainapp.coffeeserv;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import mainapp.products.CoffeesEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Coffee {
    private static SessionFactory ourSessionFactory;

    public static List<CoffeesEntity> ProductsInRep(){
        try {
            Configuration configuration = new Configuration();
            ourSessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session =ourSessionFactory.openSession();
        Transaction t = null;
        List<CoffeesEntity> stCoffee = new ArrayList<CoffeesEntity>();
        try{
            t=session.beginTransaction();
            List c=session.createQuery("FROM CoffeesEntity ").list();
            for(Iterator iterator = c.iterator(); iterator.hasNext();){
                CoffeesEntity ce = (CoffeesEntity)iterator.next();
                if(ce.getCoffeeAmount()>0)
                stCoffee.add(ce);
            }
            t.commit();
        }catch(HibernateException h){
            if(t!=null) t.rollback();
            h.printStackTrace();
        }finally {
            session.close();
        }

        return stCoffee;
    }

}