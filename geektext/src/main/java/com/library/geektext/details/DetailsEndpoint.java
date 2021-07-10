package com.library.geektext.details;

import javax.servlet.http.HttpServletRequest;

import com.library.geektext.Book;
import com.library.geektext.Author;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//The URL endpoints

@RestController
public class DetailsEndpoint {

    private final DetailsController controller;

    @Autowired
    public DetailsEndpoint(DetailsController controller){
        this.controller = controller;
    }

    @GetMapping("/api/details/book")
    public Book getStudent(HttpServletRequest req){
        String isbn = req.getParameter("isbn");
        return controller.getBookByIspn(isbn);
    }

    @PostMapping("/api/details/book")
    public Response registerNewBook(@RequestBody Book book){
        return controller.addNewBook(book);
    }

    @PostMapping("/api/details/author")
    public Response registerNewAuthor(@RequestBody Author author){
        return controller.addNewAuthor(author);
    }

    @GetMapping("/api/details/author")
    public List<Book[]> getBooksByAuthor(HttpServletRequest req){
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        return controller.getBookByAuthor(firstName, lastName);
    }

    @GetMapping("/api/details/author/id")
    public List<String> getIdByName(HttpServletRequest req){
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        return controller.getAuthorIdByName(firstName, lastName);
    }

}
