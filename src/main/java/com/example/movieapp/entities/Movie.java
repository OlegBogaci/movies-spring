package com.example.movieapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long year;
    private String title;
    private String genre;
    private String description;

    @ManyToOne
    @JoinColumn // fk column = default name = field + PK, always on the side of "MANY"
    private Producer producer;

    @JsonIgnore
    @OneToMany
    private List<Review> review;

    public Movie() {}

    public Movie(String genre, String title, String description, Long year, Producer producer) {
        this.genre = genre;
        this.title = title;
        this.description = description;
        this.year = year;
        this.producer = producer;
    }
}
