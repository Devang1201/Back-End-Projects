package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import DataLayer.Book;
import DataLayer.BookRepository;
import DataLayer.CreateBookRequest;

@Controller
public class BookController {

	@Autowired
    BookRepository bookRepository;
	
	@GetMapping(value = "/getBooks")
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
	
	@PostMapping(value = "/insertBook")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertBook(@RequestBody CreateBookRequest createRequest) throws Exception{
        try {
        	
            Book book = new Book(createRequest.getName(),createRequest.getAuthor(),createRequest.getCost(),createRequest.getBooks_in_stock());
            bookRepository.save(book);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
	
	@GetMapping(value = "/getBookByUser")
    public List<Book> getBookByUserName(@RequestParam(value = "q") String auth){
        List<Book> books = bookRepository.findBooksByUserName(auth);
//        System.out.println(books);
        return books;
    }
}
