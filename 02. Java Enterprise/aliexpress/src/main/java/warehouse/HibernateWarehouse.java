package warehouse;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import connections.HibernateConnection;

public class HibernateWarehouse implements Warehouse {

	public HibernateWarehouse() {
		HibernateConnection.createSessionFactory();
	}

	public List<Product> getProducts() {
		Session session = HibernateConnection.createSession();
		@SuppressWarnings("unchecked")
		List<Product> results = session.createQuery("FROM Product").list();
		session.close();
		return results;
	}

	public Product getProduct(String key) throws NoSuchKeyException {
		Session session = HibernateConnection.createSession();
		Query query = session.createQuery("FROM Product WHERE key=:key");
		query.setParameter("key", key);
		@SuppressWarnings("unchecked")
		List<Product> results = query.list();
		if (results.isEmpty()) {
			session.close();
			throw new NoSuchKeyException();
		}
		session.close();
		return results.get(0);
	}
	/*
	 * public static void registerPublication() { Session session =
	 * HibernateConnection.createSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); Product product = new Product();
	 * product.setName("Nesto"); product.setPrice(13); product.setQuantity(13);
	 * session.save(product); tx.commit(); } catch (RuntimeException e) { if (tx
	 * != null) { tx.rollback(); } throw new GenericDBException(); } finally {
	 * session.close(); } }
	 */

}
