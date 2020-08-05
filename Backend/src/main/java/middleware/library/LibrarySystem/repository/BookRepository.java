package middleware.library.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import middleware.library.LibrarySystem.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

	Book findByName(String name);

}
