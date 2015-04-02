package menu;

import java.util.List;
import java.util.Scanner;
import book.Book;
import book.BookDAO;
import book.BookService;

public class ConsoleMenu implements Menu {

	private Scanner in = new Scanner(System.in);
	private BookService bookService;
	private boolean end = false;

	public ConsoleMenu(BookDAO bookDAO) {
		bookService = new BookService(bookDAO);
	}

	public void listOptions() {
		System.out.println("1. List registered books");
		System.out.println("2. Register book");
		System.out.println("3. Update book registration");
		System.out.println("4. Unregister book");
		System.out.println("5. Exit");
	}

	public void listBooks() {
		List<Book> books = bookService.getBooks();
		for (Book b : books) {
			System.out.println(b.getId() + " | " + b.getIsbn() + " | "
					+ b.getTitle());
		}
	}

	public void registerBook() {
		System.out.println("Enter ISBN:");
		String isbn = in.next();
		System.out.println("Enter title:");
		String title = in.next();
		bookService.registerBook(isbn, title);
	}

	public void updateBook() {
		System.out.println("Enter ID:");
		int id = in.nextInt();
		System.out.println("Enter new ISBN:");
		String isbn = in.next();
		System.out.println("Enter new title:");
		String title = in.next();
		bookService.updateBook(id, isbn, title);
	}

	public void unregisterBook() {
		System.out.println("Enter ID:");
		bookService.unregisterBook(in.nextInt());
	}

	public void exit() {
		bookService.exit();
		in.close();
		end = true;
	}

	public void run() {
		while (!end) {
			listOptions();
			switch (in.nextInt()) {
			case 1:
				listBooks();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				updateBook();
				break;
			case 4:
				unregisterBook();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Insert 1-5!");
			}
		}
	}

}
