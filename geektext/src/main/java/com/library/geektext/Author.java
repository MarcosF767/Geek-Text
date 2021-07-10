package com.library.geektext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
        initialValue=1,
        name = "student_sequence",
        sequenceName = "student_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private int authorId;
    private String fname;
    private String lname;
    private String biography;
    private String publisher;

    public String getFirstName() {
        return fname;
    }
    public void setFirstName(String firstName) {
        this.fname = firstName;
    }
    public String getLastName() {
        return lname;
    }
    public void setLastName(String lastName) {
        this.lname = lastName;
    }
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getAuthorId(){
        return authorId;
    }
    public Author(String firstName, String lastName, String biography, String publisher) {
        this.fname = firstName;
        this.lname = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }
    public Author() {}
    public boolean isComplete(){
        if(fname.isEmpty() ||
            lname.isEmpty() ||
            biography.isEmpty() ||
            publisher.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
}
