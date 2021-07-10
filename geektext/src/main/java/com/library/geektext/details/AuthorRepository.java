package com.library.geektext.details;

import java.util.Optional;

import com.library.geektext.Author;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
    //@Query("SELECT s FROM Author s WHERE s.firstName = ?1 AND s.lastName = ?1")
    Optional<Author> findAuthorByFnameAndLname(String firstName, String lastName);


}
