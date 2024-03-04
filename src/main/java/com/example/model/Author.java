package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author extends PanacheEntity {
    private String name;
    private String age;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Movie> movieList;

    public Author(String name, String age, List<Movie> movieList) {
        this.name = name;
        this.age = age;
        this.movieList = movieList;
    }

    public Author() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
