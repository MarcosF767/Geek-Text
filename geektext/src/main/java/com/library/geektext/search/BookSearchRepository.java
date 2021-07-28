package com.library.geektext.search;

import com.library.geektext.details.*;
import java.util.List;
import java.util.Optional;

import com.library.geektext.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookSearchRepository extends JpaRepository<Book, Integer>{

    @Query("SELECT s FROM Book s WHERE s.genre = ?1")
    List<Book[]> findBookByGenre(String genre);
    
    @Query("SELECT s FROM Book s WHERE s.bookId = ?1")
    Book findBookById(int bookId);
    
    @Query("SELECT COUNT(*)\n" +
"FROM Book s")
    int getAllBooks();
    
}
