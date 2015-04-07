package warehouse.dao.templates;

import org.hibernate.Session;
import warehouse.connections.HibernateConnection;

public class HibernateTemplate {

	public <T> T returnQuery(HibernateGetSetter hibernateGetSetter) {
		Session session = HibernateConnection.createSession();
		T object = hibernateGetSetter.returnQuery(session);
		session.close();
		return object;
	}
}
