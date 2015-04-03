package book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String isbn;
	private String title;

	public Book() {

	}

	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}

	public Book(int id, String isbn, String title) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
