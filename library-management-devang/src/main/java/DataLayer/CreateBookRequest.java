package DataLayer;

public class CreateBookRequest {

    private String name;
    private String author;
    private int cost;
    private int books_in_stock;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getBooks_in_stock() {
		return books_in_stock;
	}

	public void setBooks_in_stock(int books_in_stock) {
		this.books_in_stock = books_in_stock;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
