package com.library.geektext.search;

import com.library.geektext.details.*;
import javax.servlet.http.HttpServletRequest;

import com.library.geektext.Book;
import com.library.geektext.Author;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//The URL endpoints
@RestController
public class DetailsSearchEndpoint {

    private final DetailsSearchController controller;

    @Autowired
    public DetailsSearchEndpoint(DetailsSearchController controller) {
        this.controller = controller;
    }

    @GetMapping("/api/search/genre")
    public List<Book[]> getBookByGenre(HttpServletRequest req) {
        String genre = req.getParameter("genre");
        return controller.getBookByGenre(genre);
    }

    class SortbyCopiesSold implements Comparator<Book> {
        @Override
        public int compare(Book a, Book b) {
            return b.getCopiesSold() - a.getCopiesSold();
        }
    }

    @GetMapping("/api/search/sold")
    public List<Book> getBookById(HttpServletRequest req) {

        int bookAmount = controller.getBookAmount();

        List<Book> tempBooks = new ArrayList<>();
        for (int i = 1; i <= bookAmount; i++) 
                tempBooks.add(controller.getBookById(i));
        Collections.sort(tempBooks, new SortbyCopiesSold());
        
        
        if (bookAmount > 10){
            for (int i = bookAmount-1; i > 10; i--){
                tempBooks.remove(i);
            }
            tempBooks.remove(10);
        }
        
        return tempBooks;
    }

    @GetMapping("/api/search/retrieve")
    public List<Book> getXBooks(HttpServletRequest req) {
        int amount = Integer.parseInt(req.getParameter("amount"));
        int bookAmount = controller.getBookAmount();
        
        List<Book> books = new ArrayList<>();
        
        if (amount <= bookAmount) {
            for (int i = 1; i <= amount; i++) 
                books.add(controller.getBookById(i));
        } else {
            for (int i = 1; i <= bookAmount; i++) 
                books.add(controller.getBookById(i));
        }
        return books;
    }
}
