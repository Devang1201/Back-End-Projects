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

import DataLayer.CreateUserRequest;
import DataLayer.User;
import DataLayer.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/getUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
	
	@PostMapping(value = "/insertUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertUser(@RequestBody CreateUserRequest createRequest) throws Exception{
        try {
            User user = new User(createRequest.getName());
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
	
	@GetMapping(value = "/getUserByBook")
    public List<User> getUserByBookName(@RequestParam(value = "q") String auth){
        List<User> users = userRepository.findUsersByBookName(auth);
//        System.out.println(books);
        return users;
    }
}
