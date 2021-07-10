package com.library.geektext.details;

import java.util.List;
import java.util.Optional;

import com.library.geektext.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
    @Query("SELECT s FROM Book s WHERE s.isbn = ?1")
    Optional<Book> findBookByISBN(String isbn);

    List<Book[]> findBooksByAuthorId(int authorId);
}
