package middleware.library.LibrarySystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import middleware.library.LibrarySystem.entity.Book;
import middleware.library.LibrarySystem.service.BookService;

@RestController
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
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return service.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(int id) {
		return service.getBooksByISBN(id);
	}
	
	@GetMapping("/book/{name}")
	public Book getBookByName(String name) {
		return service.getBooksByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(int id) {
		return service.deleteBook(id);
		
	}
	
	@PostMapping("/update")
	public Book updateBook(@RequestBody Book book){
		return service.updateBook(book);
	}
	

}
