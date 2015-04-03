package connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import warehouse.Product;

public class HibernateConnection {

	private static SessionFactory sessionFactory;

	public static void createSessionFactory() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Product.class)
				.buildSessionFactory(serviceRegistry);
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static Session createSession() {
		return sessionFactory.openSession();
	}
}
