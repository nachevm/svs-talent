package book;

import java.util.List;

public interface BookDAO {

	public List<Book> getBooks();

	public void registerBook(String isbn, String title);

	public void updateBook(int id, String isbn, String title)
			throws NoSuchIdException;

	public void unregisterBook(int id) throws NoSuchIdException;
	
	public void checkISBN(String isbn) throws IsbnExistsException;
}
