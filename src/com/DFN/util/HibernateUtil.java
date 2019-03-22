package com.DFN.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    static {
        try {
            Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");

            sessionFactory = cfg.buildSessionFactory();
        } catch (Exception e) {
            throw e;
        }

    }

    public static Session getSessionobject() {
        return sessionFactory.getCurrentSession();
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();

    }
    //public static void main(String[] args) {

    //}
}
	/*public static void add(Object entity) {
		Session s=null;
		Transaction tx = null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.save(entity);
			tx.commit();
		}finally {
			if(s!= null)
				s.close();
		}
	}
	public static void update(Object entity) {
		Session s=null;
		Transaction tx = null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.update(entity);
			tx.commit();
		}finally {
			if(s!= null)
				s.close();
		}
	
	
	}
	public static void delete(Object entity) {
		Session s=null;
		Transaction tx = null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.delete(entity);
			tx.commit();
		}finally {
			if(s!= null)
				s.close();
		}
	
	
	}
	public static Object get(Class clazz,Serializable id) {
		Session s=null;
		
		try {
			s=HibernateUtil.getSession();
			
			Object obj=s.get(clazz,id);
			return obj;
		
		}finally {
			if(s!= null)
				s.close();
		}
	}
	
}*/
