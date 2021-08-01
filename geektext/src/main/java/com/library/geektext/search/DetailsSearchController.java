package com.library.geektext.search;

import java.util.List;

import com.library.geektext.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsSearchController {

    private final BookSearchRepository bookRepo;

    @Autowired
    public DetailsSearchController(BookSearchRepository repo){
        this.bookRepo = repo;
    }
    
    public List<Book[]> getBookByGenre(String genre){
        return bookRepo.findBookByGenre(genre);
    }
    
    public Book getBookById(int bookId){
        return bookRepo.findBookById(bookId);
    }
    
    public int getBookAmount(){
        return bookRepo.getAllBooks();
    }
}
