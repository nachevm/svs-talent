package book;

import java.util.List;

import services.exceptions.IsbnExistsException;
import services.exceptions.NoSuchIdException;
import entities.Publication;

public interface PublicationDAO {

	public List<Publication> getPublications();

	public void registerPublication(Publication publication);

	public void updatePublication(Publication publication);

	public void unregisterPublication(int id) throws NoSuchIdException;

	public void checkISBN(String isbn) throws IsbnExistsException;

	public Publication getPublication(int id) throws NoSuchIdException;
}
