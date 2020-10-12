package DataLayer;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "author")
	private String author;
	
	private int cost;
	private int books_in_stocks;
	
	public Book(String name, String author, int cost, int books_in_stocks) {
		this.name = name;
		this.author = author;
		this.cost = cost;
		this.books_in_stocks = books_in_stocks;
	}

	public Book() {}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
