package book;
/*
import java.util.List;
import java.util.Scanner;

import entities.Book;
import entities.Publication;
import book.PublicationDAO;
import book.PublicationService;

public class PublicationConsoleMenu implements Menu {

	private Scanner in = new Scanner(System.in);
	private PublicationService publicationService;
	private boolean end = false;

	public PublicationConsoleMenu(PublicationDAO publicationDAO) {
		publicationService = new PublicationService(publicationDAO);
	}

	public void listOptions() {
		System.out.println("1. List registered publications");
		System.out.println("2. Register publication");
		System.out.println("3. Update publication registration");
		System.out.println("4. Unregister publication");
		System.out.println("5. Exit");
	}

	public void listPublications() {
		List<Publication> publications = publicationService.getPublications();
		for (Publication b : publications) {
			if (b instanceof Book) {
				System.out.println(b.getId() + " | " + b.getIsbn() + " | "
						+ b.getTitle());
			}
			if (b instanceof Magazine) {
				System.out.println(b.getId() + " | " + b.getIssn() + " | "
						+ b.getTitle());
			}
		}
	}

	public void registerPublication() {
		System.out.println("Enter ISBN:");
		String isbn = in.next();
		System.out.println("Enter title:");
		String title = in.next();
		publicationService.registerPublication(isbn, title);
	}

	public void updatePublication() {
		System.out.println("Enter ID:");
		int id = in.nextInt();
		System.out.println("Enter new ISBN:");
		String isbn = in.next();
		System.out.println("Enter new title:");
		String title = in.next();
		publicationService.updatePublication(id, isbn, title);
	}

	public void unregisterPublication() {
		System.out.println("Enter ID:");
		publicationService.unregisterPublication(in.nextInt());
	}

	public void exit() {
		publicationService.exit();
		in.close();
		end = true;
	}

	public void run() {
		while (!end) {
			listOptions();
			switch (in.nextInt()) {
			case 1:
				listPublications();
				break;
			case 2:
				registerPublication();
				break;
			case 3:
				updatePublication();
				break;
			case 4:
				unregisterPublication();
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
*/