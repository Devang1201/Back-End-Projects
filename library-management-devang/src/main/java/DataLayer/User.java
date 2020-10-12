package DataLayer;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	private int mobile_number;
	private String email;
	private int number_of_books_rented;
	
	@Temporal(TemporalType.DATE)
	private Date due_date_fine;

	public User(String name2) {
		this.name = name2;
	}
	
	public User() {}
	
	
}
