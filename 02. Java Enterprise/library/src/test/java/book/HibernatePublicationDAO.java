package book;
/*
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.connections.HibernateConnection;
import entities.Publication;
import exceptions.IsbnExistsException;
import exceptions.IssnExistsException;
import exceptions.NoSuchIdException;

public class HibernatePublicationDAO implements PublicationDAO {

	public HibernatePublicationDAO() {
		HibernateConnection.createSessionFactory();
	}

	public List<Publication> getPublications() {
		Session session = HibernateConnection.createSession();
		@SuppressWarnings("unchecked")
		List<Publication> results = session.createQuery("FROM Publication").list();
		session.close();
		return results;
	}
	
	public void registerPublication(Publication publication) {
		Session session = HibernateConnection.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Publication(isbn, title));
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new DBException();
		} finally {
			session.close();
		}
	}

	public void updatePublication(Publication publication) {
		Session session = HibernateConnection.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Publication publication = (Publication) session.get(Publication.class, id);
			publication.setIsbn(isbn);
			publication.setTitle(title);
			session.save(publication);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new DBException();
		} finally {
			session.close();
		}
	}
	
	// DO TUKA OK

	public void unregisterPublication(int id) throws NoSuchIdException {
		Session session = HibernateConnection.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Publication publication = (Publication) session.get(Publication.class, id);
			session.delete(publication);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new NoSuchIdException();
		} finally {
			session.close();
		}
	}

	public void checkISBN(String isbn) throws IsbnExistsException {
		Session session = HibernateConnection.createSession();
		Query query = session.createQuery("FROM Book WHERE isbn=:isbn");
		query.setParameter("isbn", isbn);
		@SuppressWarnings("unchecked")
		List<Publication> results = query.list();
		if (!results.isEmpty()) {
			throw new IsbnExistsException();
		}
		session.close();
	}
	
	public void checkISSN(String issn) throws IssnExistsException {
		Session session = HibernateConnection.createSession();
		Query query = session.createQuery("FROM Magazine WHERE issn=:issn");
		query.setParameter("issn", issn);
		@SuppressWarnings("unchecked")
		List<Publication> results = query.list();
		if (!results.isEmpty()) {
			throw new IssnExistsException();
		}
		session.close();
	}

	public Publication getPublication(int id) throws NoSuchIdException {
		Session session = HibernateConnection.createSession();
		Query query = session.createQuery("FROM Book WHERE id=:id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Publication> results = query.list();
		if (!results.isEmpty()) {
			session.close();
			throw new NoSuchIdException();
		}
		session.close();
		return results.get(0);
	}

}
*/