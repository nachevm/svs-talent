package application;

import book.BookDAO;
import book.HibernateBookDAO;
import book.JDBCBookDAO;
import menu.ConsoleMenu;
import menu.Menu;

public class LibraryApplication {

	private static int dao = 1; // 1 = JDBC, 2 = Hibernate

	public static void main(String[] args) {

		BookDAO bookDAO;
		if (dao == 1) {
			bookDAO = new JDBCBookDAO();
		} else {
			bookDAO = new HibernateBookDAO();
		}
		Menu menu = new ConsoleMenu(bookDAO);
		menu.run();
	}
}
