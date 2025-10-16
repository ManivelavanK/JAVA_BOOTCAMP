package com.netflixtracker.netflix_tracker;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/top-rated")
    public List<Movie> topRatedMovies() {
        return service.getTopRatedMovies();
    }

    @GetMapping("/most-watched")
    public List<Map<String, Object>> mostWatchedMovies() {
        return service.getMostWatchedMovies();
    }
}