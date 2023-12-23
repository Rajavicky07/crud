package com.dbconfig;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Hibernateutil {

	private static SessionFactory sessionFactory=null;
	static
	{
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.configure("HiberCrud.cfg.xml");
			sessionFactory=config.buildSessionFactory();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
