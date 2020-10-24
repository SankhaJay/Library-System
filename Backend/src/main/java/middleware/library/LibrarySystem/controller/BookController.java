package middleware.library.LibrarySystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import middleware.library.LibrarySystem.entity.Book;
import middleware.library.LibrarySystem.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService service;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return service.saveBook(book);
		
	}
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books){
		return service.saveBooks(books);
	}
	@GetMapping("/getAll")
	public List<Book> getAllBooks(){
		return service.getBooks();
	}
	
	@GetMapping("/getById/{id}")
	public Book getBookById(@PathVariable int id) {
		return service.getBooksByISBN(id);
	}
	
	@GetMapping("/getByTitle/{title}")
	public Book getBookByTite(@PathVariable String title) {
		return service.getBooksByTitle(title);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return service.deleteBook(id);
		
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book){
		System.out.println("------------------------------");
		System.out.println(book);
		return service.updateBook(book);
	}
	

}
