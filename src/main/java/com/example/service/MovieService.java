package com.example.service;

import com.example.model.Author;
import com.example.model.Movie;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MovieService {
    public MovieService() {
    }
    @Transactional
    public Movie addMovie(Movie movie){
        Movie.persist(movie);
        return movie;
    }
    @Transactional
    public List<Movie> findMovies(){
        return Movie.listAll();
    }
    @Transactional
    public Boolean deleteMovieById(Long id){
        return Movie.deleteById(id);
    }
    @Transactional
    public Movie updateMovieById(Long id,Movie movie){
        Movie tempMovie = Movie.findById(id);
        tempMovie.setName(movie.getName());
        Movie.persist(tempMovie);
        return tempMovie;
    }
    @Transactional
    public Movie findMovieById(Long id){return Movie.findById(id);}

    @Transactional
    public Author affectMovieToAuthor(Long idmovie,Long idauth){
        Movie mv = Movie.findById(idmovie);
        Author auth = Author.findById(idauth);
        if(mv != null && auth != null){
            auth.getMovieList().add(mv);
            Author.persist(auth);
            return auth;
        }
        return new Author();
    }
}
