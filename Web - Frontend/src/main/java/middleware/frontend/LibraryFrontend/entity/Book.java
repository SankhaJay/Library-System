package middleware.frontend.LibraryFrontend.entity;

public class Book {

	private int isbn;
	private String title;
	private String publisher;
	private int numberOfBooks;
	private int price;

	public Book() {

	}

	public Book(int isbn, String title, String publisher, int numberOfBooks, int price) {
		super();
		System.out.println("constructor....");
		System.out.println(numberOfBooks);
		System.out.println(price);
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.numberOfBooks = numberOfBooks;
		this.price = price;
	}

	public int getISBN() {
		return isbn;
	}

	public void setISBN(int isbn) {
		this.isbn = isbn;
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
		System.out.println("setting books....");
		System.out.println(numberOfBooks);
		this.numberOfBooks = numberOfBooks;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setting price....");
		System.out.println(price);
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publisher=" + publisher + ", numberOfBooks="
				+ numberOfBooks + ", price=" + price + "]";
	}

}
