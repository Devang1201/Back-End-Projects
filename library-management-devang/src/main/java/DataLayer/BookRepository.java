package DataLayer;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query(value = "SELECT * FROM book WHERE book.id IN (SELECT rent.book_id FROM rent WHERE rent.user_id IN (SELECT user.id FROM user WHERE user.name = :username))", nativeQuery = true)
	List<Book> findBooksByUserName(String username);
	
	@Query(value = "SELECT book.id FROM book WHERE book.name = :bookname", nativeQuery = true)
	int findIdByBookName(String bookname);
	
	@Query(value = "SELECT book.books_in_stocks FROM book WHERE book.id = :id", nativeQuery = true)
	int findAvailableQuantity(int id);
}
