package com.netflixtracker.netflix_tracker;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String genre;
    private Integer releaseYear;
    private Integer duration; // in minutes
    private Double ratingAvg;
    private String contentType; // Movie or Series
}