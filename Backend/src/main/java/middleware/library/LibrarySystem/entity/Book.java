package middleware.library.LibrarySystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="book")
public class Book {
	
	public Book() {};
	
	public Book(int iSBN, String title, String publisher, int number_of_books, int price) {
        super();
        this.ISBN=iSBN;
        this.title=title;
        this.publisher=publisher;
        this.numberOfBooks=numberOfBooks;
        this.price = price;
        
    }
	 @Override
	    public String toString() {
	        return "Book [ISBN=" + ISBN + ", title=" + title + ", publisher=" + publisher + ", number_of_books=" + numberOfBooks + ", price="
	                + price + "]";
	    }
	 
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		this.ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Id
	@GeneratedValue
	private int ISBN;
	private String title;
	private String publisher;
	private int numberOfBooks;
	private int price;
	
	
	
	
}
