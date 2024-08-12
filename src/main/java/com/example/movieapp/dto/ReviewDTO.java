package com.example.movieapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
    private String reviewerName;
    private String comment;
    private Double rate;
    private Long movieId;
}
