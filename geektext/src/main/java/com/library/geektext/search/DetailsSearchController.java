package com.library.geektext.search;

import com.library.geektext.details.*;
import java.util.List;
import java.util.Optional;

import com.library.geektext.Author;
import com.library.geektext.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsSearchController {

    private final BookSearchRepository bookRepo;
    private final AuthorRepository authorRepo;

    @Autowired
    public DetailsSearchController(BookSearchRepository repo, AuthorRepository authorRepo){
        this.bookRepo = repo;
        this.authorRepo = authorRepo;
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
