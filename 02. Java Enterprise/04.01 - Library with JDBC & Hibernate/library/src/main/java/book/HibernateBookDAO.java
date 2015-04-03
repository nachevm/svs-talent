package book;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connections.HibernateConnection;

public class HibernateBookDAO implements BookDAO {

	public HibernateBookDAO() {
		HibernateConnection.createSessionFactory();
	}

	public List<Book> getBooks() {
		Session session = HibernateConnection.createSession();
		List<Book> results = session.createQuery("FROM Book").list();
		session.close();
		return results;
	}

	public void registerBook(String isbn, String title) {
		Session session = HibernateConnection.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Book(isbn, title));
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
			throw new DBException();
		} finally {
			session.close();
		}
	}

	public void updateBook(int id, String isbn, String title)
			throws NoSuchIdException {
		Session session = HibernateConnection.createSession();
		Query query = session
				.createQuery("UPDATE Book SET isbn=:isbn, title=:title WHERE id=:id");
		query.setParameter("isbn", isbn);
		query.setParameter("title", title);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		session.close();
		if (result == 0) {
			throw new NoSuchIdException();
		}
	}

	public void unregisterBook(int id) throws NoSuchIdException {
		Session session = HibernateConnection.createSession();
		Query query = session.createQuery("DELETE FROM Book WHERE id=:id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		session.close();
		if (result == 0) {
			throw new NoSuchIdException();
		}
	}

	public void checkISBN(String isbn) throws IsbnExistsException {
		Session session = HibernateConnection.createSession();
		Query query = session.createQuery("FROM Book WHERE isbn=:isbn");
		query.setParameter("isbn", isbn);
		List<Book> results = query.list();
		if (!results.isEmpty()) {
			session.close();
			throw new IsbnExistsException();
		}
		session.close();
	}

}
