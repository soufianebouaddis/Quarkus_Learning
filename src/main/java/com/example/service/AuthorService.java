package com.example.service;

import com.example.model.Author;
import com.example.model.Movie;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AuthorService {
    public AuthorService(){}
    @Transactional
    public Author addAuthor(Author author){
        Author.persist(author);
        return author;
    }
    @Transactional
    public List<Author> findAuthors(){
        return Author.listAll();
    }
    @Transactional
    public Boolean deleteAuthorById(Long id){
        return Author.deleteById(id);
    }
    @Transactional
    public Author updateAuthorById(Long id,Author author){
        Author tempAuth = Author.findById(id);
        tempAuth.setName(author.getName());
        tempAuth.setAge(author.getAge());
        tempAuth.setMovieList(author.getMovieList());
        Author.persist(tempAuth);
        return tempAuth;
    }
    @Transactional
    public Author findAuthorById(Long id){return Author.findById(id);}

}
