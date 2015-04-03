package book;

import java.util.List;

import connections.HibernateConnection;
import logging.ConsoleLogger;
import logging.Logger;

public class BookService {

	private BookDAO bookDAO;
	private Logger logger = new ConsoleLogger();

	public BookService(BookDAO b) {
		bookDAO = b;
	}

	public List<Book> getBooks() {
		try {
			List<Book> books = bookDAO.getBooks();
			return books;
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		}
		return null;
	}

	public void registerBook(String isbn, String title) {
		try {
			bookDAO.checkISBN(isbn);
			bookDAO.registerBook(isbn, title);
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		} catch (IsbnExistsException e) {
			logger.log("ISBN already exists!");
		}
	}

	public void updateBook(int id, String isbn, String title) {
		try {
			bookDAO.updateBook(id, isbn, title);
		} catch (NoSuchIdException e) {
			logger.log("No such book ID!");
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		}

	}

	public void unregisterBook(int id) {
		try {
			bookDAO.unregisterBook(id);
		} catch (NoSuchIdException e) {
			logger.log("No such book ID!");
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		}
	}

	public void exit() {
		if (bookDAO instanceof HibernateBookDAO) {
			HibernateConnection.closeSessionFactory();
		}
	}

}
