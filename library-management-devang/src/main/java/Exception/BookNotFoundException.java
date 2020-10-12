package Exception;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException()
	{
		System.out.println("Book not found");
	}
}
