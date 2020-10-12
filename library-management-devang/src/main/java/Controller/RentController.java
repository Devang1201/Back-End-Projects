package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import DataLayer.BookRepository;
import DataLayer.CreateRentRequest;
import DataLayer.Rent;
import DataLayer.RentRepository;
import Exception.BookNotFoundException;

@Controller
public class RentController {

	@Autowired
	RentRepository rentRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@PostMapping(value = "/insertRent")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertRent(@RequestBody CreateRentRequest createRequest) throws Exception{
        try {
        	int books_in_stock = bookRepository.findAvailableQuantity(createRequest.getBookId());
        	if(books_in_stock > 0)
        		throw new BookNotFoundException();
        	
            Rent rent = new Rent(createRequest.getUserId(), createRequest.getBookId());
            rentRepository.save(rent);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
}
