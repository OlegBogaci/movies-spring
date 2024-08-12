package com.example.movieapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(insertable = false, updatable = false)
    private Double rating;

    @JsonIgnore
    @OneToMany
    private List<Movie> movies;

    public Producer() {}

    public Producer(Long id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
}