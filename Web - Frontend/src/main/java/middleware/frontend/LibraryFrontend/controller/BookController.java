package middleware.frontend.LibraryFrontend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import middleware.frontend.LibraryFrontend.entity.Book;
import middleware.frontend.LibraryFrontend.entity.User;

@RestController
public class BookController {
	@Autowired
	private RestTemplate restTemplate;
	
	 @RequestMapping("/book")
	    public ModelAndView bookHome() {
	        ModelAndView modelAndView = new ModelAndView();
	        String URL = "http://localhost:3000/book/getAll";
	        Object[] books = restTemplate.getForObject(URL, Object[].class);
	        modelAndView.addObject("books", books);
	        modelAndView.setViewName("/book.jsp");
	        return modelAndView;
	    }
	 
	 @RequestMapping("/add-book")
	    public ModelAndView bookAdd() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("/book_add.jsp");
	        return modelAndView;
	    }
	 
	    @PostMapping("/create_book")
	    public ModelAndView createBook(Book book) {
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
	    
	    @RequestMapping("/edit_book/{isbn}")
	    public ModelAndView editBook(@PathVariable int isbn) {
	        ModelAndView modelAndView = new ModelAndView();
	        String URL = "http://localhost:3000/book/getById/"+ isbn;
	        Object book = restTemplate.getForObject(URL, Object.class);
	        System.out.println(book);
	        modelAndView.addObject("book", book);
	        modelAndView.setViewName("/edit_book.jsp");
	        return modelAndView;
	    }
	    
	    @PostMapping("/edit_book_form")
	    public RedirectView editBook(Book book) {
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println("ID "+ book.getISBN());
	        String URL = "http://localhost:3000/book/update";
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<Object> request = new HttpEntity<Object>(book, headers);
	        restTemplate.put(URL, request, Object.class);
	        modelAndView.setViewName("/edit_book.jsp");
	        RedirectView redirectView = new RedirectView();
	        redirectView.setUrl("http://localhost:9090/book");
	        return redirectView;
	    }
	    
	    @PostMapping("/filter_book")
	    public ModelAndView filter_book(Book book) {
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println(book.getTitle());
	        String URL = "http://localhost:3000/book/getByTitle/" + book.getTitle();
	        Object[] books = restTemplate.getForObject(URL, Object[].class);
	        modelAndView.addObject("books", books);
	        modelAndView.setViewName("/book.jsp");
	        return modelAndView;
	    }

	    
	    @DeleteMapping("/deleteBook/{id}")
	    public RedirectView deleteBook(@PathVariable int id) {
	        System.out.println(id);
	        ModelAndView modelAndView = new ModelAndView();
	        String URL = "http://localhost:3000/book/delete/" + id;
	        try {
	            restTemplate.delete(URL);
	        } catch (Exception exception) {
	            exception.getMessage();
	        } finally {
	            String books_URL = "http://localhost:3000/book/getAll";
	            Object[] books = restTemplate.getForObject(books_URL, Object[].class);
	            RedirectView redirectView = new RedirectView();
	            redirectView.setUrl("http://localhost:9090/book");
	            return redirectView;
	        }
	    }
	
}
