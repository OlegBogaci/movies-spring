package com.example.movieapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
    private Long year;
    private String title;
    private String genre;
    private String description;
    private Long producerId;
}
