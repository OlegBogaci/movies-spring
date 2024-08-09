package com.example.movieapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewerName;
    private String comment;
    private Long rate;

    @ManyToOne
    @JoinColumn // default name = field + PK
    private Movie movie;

    public Review(String reviewerName, String comment, Long rate) {
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.rate = rate;
    }
}
