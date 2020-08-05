package middleware.library.LibrarySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleware.library.LibrarySystem.entity.Book;
import middleware.library.LibrarySystem.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public Book saveBook(Book book) {
		return repository.save(book);
	}
	
	public List<Book> saveBooks(List<Book> books) {
		return repository.saveAll(books);
	}
	
	public List<Book> getBooks() {
		return repository.findAll();
	}
	
	public Book getBooksByISBN(int isbn) {
		return repository.findById(isbn).orElse(null);
	}
	
	public Book getBooksByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteBook(int isbn) {
		repository.deleteById(isbn);
		return "Book is deleted by Id";
	}
	
	public Book updateBook(Book book) {
		Book existingBook=repository.findById(book.getISBN()).orElse(null);
		existingBook.setTitle(book.getTitle());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setPrice(book.getPrice());
		existingBook.setNumberOfBooks(book.getNumberOfBooks());
		
		return repository.save(existingBook);
		
	}
	
	
	

}
