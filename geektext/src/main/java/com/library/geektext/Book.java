package com.library.geektext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Integer bookId;
    private String isbn;
    private String name;
    private String description;
    private String price;
    private int authorId;
    private String genre;
    private String publisher;
    private int publishYear;
    private int copiesSold;

    public Book(String iSBN, String name, String description, String price, int authorId, String genre,
            String publisher, int publishYear, int copiesSold) {
        this.isbn = iSBN;
        this.name = name;
        this.description = description;
        this.price = price;
        this.authorId = authorId;
        this.genre = genre;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.copiesSold = copiesSold;
    }

    public Book() { }

    public String getIsbn() {
        return isbn;
    }
    public void setISBN(String iSBN) {
        this.isbn = iSBN;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    public int getCopiesSold() {
        return copiesSold;
    }
    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
    public boolean isComplete(){
        if(
            isbn.isEmpty() ||
            name.isEmpty() ||
            description.isEmpty() ||
            price.isEmpty() ||
            authorId == 0 ||
            genre.isEmpty() ||
            publisher.isEmpty() ||
            publishYear == 0
        ){
            return false;
        }
        else{
            return true;
        }
    }

    
}
