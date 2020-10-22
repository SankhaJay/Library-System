package middleware.library.LibrarySystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import middleware.library.LibrarySystem.entity.Book;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {

	List<Book> getByTitle(String title);

}
