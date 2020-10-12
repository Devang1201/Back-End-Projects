package DataLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query(value = "SELECT * FROM user WHERE user.id IN (SELECT rent.user_id FROM rent WHERE rent.book_id IN (SELECT book.id FROM book WHERE book.name = :bookname))", nativeQuery = true)
	List<User> findUsersByBookName(String bookname);
	
	@Query(value = "SELECT user.id FROM user WHERE user.name = :username", nativeQuery = true)
	int findIdByUserName(String username);

//	List<Book> findUserByUserName(String auth);
}
