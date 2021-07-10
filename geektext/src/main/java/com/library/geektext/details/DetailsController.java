package com.library.geektext.details;

import java.util.List;
import java.util.Optional;

import com.library.geektext.Author;
import com.library.geektext.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsController {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    @Autowired
    public DetailsController(BookRepository repo, AuthorRepository authorRepo){
        this.bookRepo = repo;
        this.authorRepo = authorRepo;
    }
    
    public Book getBookByIspn(String isbn){
        return bookRepo.findBookByISBN(isbn).orElseThrow(() -> new IllegalStateException("Book does not exist"));
    }

    public Response addNewBook(Book book){

        Optional<Book> foundBook = bookRepo.findBookByISBN(book.getIsbn());

        if(foundBook.isPresent()){
            return new Response("400", "Book with isbn " + book.getIsbn() + " already exists.");
        }

        if(book.isComplete()){
            bookRepo.save(book);
            return new Response("200", "Book " + book.getName() + " saved successfully.");
        }
        else{
            return new Response("400", 
            "Book " + book.getName() + " is missing information." +
            "\nMust include isbn, name, description, price, authorId, genre, publisher, and publishYear." +
            "\nOptional: copiesSold.");
        }
    }

    public Response addNewAuthor(Author author){
        Optional<Author> foundAuthor = 
            authorRepo.findAuthorByFnameAndLname(author.getFirstName(), author.getLastName());

        if(foundAuthor.isPresent()){
            return new Response("400", "Author with first name " + author.getFirstName() + 
            " and last name " + author.getLastName() + " already exists.");
        }

        if(author.isComplete()){
            authorRepo.save(author);
            return new Response("200", "Author " + author.getFirstName() +
            " " + author.getLastName() + " saved successfully.");
        }
        else{
            return new Response("400", 
            "The Author is missing information." +
            "\nMust include a firstName, lastName, biography, and publisher.");
        }
    }

    public List<Book[]> getBookByAuthor(String firstName, String lastName){
        Optional<Author> foundAuthor = authorRepo.findAuthorByFnameAndLname(firstName, lastName);
        
        if(!foundAuthor.isPresent()){
            throw(new IllegalStateException("Author does not exist"));
        }

        Author author = authorRepo.findAuthorByFnameAndLname(firstName, lastName).orElse(new Author());
        
        List<Book[]> foundBook = bookRepo.findBooksByAuthorId(author.getAuthorId());

        if(foundBook.isEmpty()){
            throw(new IllegalStateException("No Books under this Author"));
        }
        
        return bookRepo.findBooksByAuthorId(author.getAuthorId());

    }

    public List<String> getAuthorIdByName(String firstName, String lastName){
        Optional<Author> foundAuthor = authorRepo.findAuthorByFnameAndLname(firstName, lastName);
        if(!foundAuthor.isPresent()){
            throw(new IllegalStateException("Author does not exist"));
        }
        Author author = authorRepo.findAuthorByFnameAndLname(firstName, lastName).orElse(new Author());
        return List.of(Integer.toString(author.getAuthorId()));
    }

}
