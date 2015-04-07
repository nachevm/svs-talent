package warehouse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Transaction;

import warehouse.Product;
import warehouse.connections.HibernateConnection;
import warehouse.dao.templates.HibernateGetSetter;
import warehouse.dao.templates.HibernateTemplate;

public class HibernateWarehouse implements Warehouse {

	public HibernateWarehouse() {
		HibernateConnection.createSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {

		return new HibernateTemplate().returnQuery(new HibernateGetSetter() {

			public List<Product> returnQuery(Session session) {
				List<Product> results = session.createQuery("FROM Product")
						.list();
				return results;
			}

		});

	}

	@SuppressWarnings("unchecked")
	public Product getProduct(final String key) {

		return new HibernateTemplate().returnQuery(new HibernateGetSetter() {

			public Product returnQuery(Session session) {
				Query query = session
						.createQuery("FROM Product WHERE key=:key");
				query.setParameter("key", key);
				return (Product) query.uniqueResult();
			}

		});

	}

	public void exit() {
		HibernateConnection.closeSessionFactory();
	}
	
	/*
	public static void addProduct() {
		Session session = HibernateConnection.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Product("00", "Test", 100, 10));
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	*/
}
