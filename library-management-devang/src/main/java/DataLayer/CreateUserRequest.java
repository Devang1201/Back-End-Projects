package DataLayer;

public class CreateUserRequest {

    private String name;
    private int mobile_number;
    private String email;
    private int number_of_books_rented;

	public int getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber_of_books_rented() {
		return number_of_books_rented;
	}

	public void setNumber_of_books_rented(int number_of_books_rented) {
		this.number_of_books_rented = number_of_books_rented;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
