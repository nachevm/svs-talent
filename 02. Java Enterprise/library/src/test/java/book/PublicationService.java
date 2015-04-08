package book;
/*
import java.util.List;

import dao.connections.HibernateConnection;
import entities.Publication;
import exceptions.NoSuchIdException;
import logging.ConsoleLogger;
import logging.Logger;

public class PublicationService {

	private PublicationDAO publicationDAO;
	private Logger logger = new ConsoleLogger();

	public PublicationService(PublicationDAO b) {
		publicationDAO = b;
	}

	public List<Publication> getPublications() {
		try {
			List<Publication> publications = publicationDAO.getPublications();
			return publications;
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		}
		return null;
	}

	public void registerPublication(Publication publication) {
		try {
			//publicationDAO.checkISBN(publicationisbn);
			publicationDAO.registerPublication(publication);
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		} //catch (IsbnExistsException e) {
			//logger.log("ISBN already exists!");
		//}
	}

	public void updatePublication(Publication publication) {
		try {
			publicationDAO.updatePublication(publication);
		} catch (NoSuchIdException e) {
			logger.log("No such publication ID!");
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		}

	}

	public void unregisterPublication(int id) {
		try {
			publicationDAO.unregisterPublication(id);
		} catch (NoSuchIdException e) {
			logger.log("No such publication ID!");
		} catch (DBException e) {
			logger.log("We're sorry. An error has occured.");
		}
	}

	public void exit() {
		if (publicationDAO instanceof HibernatePublicationDAO) {
			HibernateConnection.closeSessionFactory();
		}
	}

}
*/