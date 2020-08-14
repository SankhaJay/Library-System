package middleware.frontend.LibraryFrontend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import middleware.frontend.LibraryFrontend.entity.Book;
import middleware.frontend.LibraryFrontend.entity.User;

@RestController
public class BookController {
	@Autowired
	private RestTemplate restTemplate;
	
	 @RequestMapping("/book")
	    public ModelAndView userHome() {
	        ModelAndView modelAndView = new ModelAndView();
	        String URL = "http://localhost:3000/book/getAll";
	        Object[] books = restTemplate.getForObject(URL, Object[].class);
	        modelAndView.addObject("books", books);
	        modelAndView.setViewName("/book.jsp");
	        return modelAndView;
	    }
	 
	 @RequestMapping("/add-book")
	    public ModelAndView userAdd() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("/book_add.jsp");
	        return modelAndView;
	    }
	 
	    @PostMapping("/create_book")
	    public ModelAndView createUser(Book book) {
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println(book.getTitle());
	        String URL = "http://localhost:3000/book/addBook";
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<Object> request = new HttpEntity<Object>(book, headers);
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        restTemplate.postForObject(URL, request, Object.class);
	        modelAndView.setViewName("/book_add.jsp");
	        return modelAndView;
	    }

	
}
