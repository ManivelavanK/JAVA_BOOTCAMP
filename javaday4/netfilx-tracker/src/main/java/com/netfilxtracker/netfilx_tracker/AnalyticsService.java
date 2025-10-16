package com.netflixtracker.netflix_tracker;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private final WatchHistoryRepository watchRepo;
    private final MovieRepository movieRepo;

    public AnalyticsService(WatchHistoryRepository watchRepo, MovieRepository movieRepo) {
        this.watchRepo = watchRepo;
        this.movieRepo = movieRepo;
    }

    public List<Movie> getTopRatedMovies() {
        return movieRepo.findAll()
                .stream()
                .sorted((a, b) -> Double.compare(b.getRatingAvg(), a.getRatingAvg()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getMostWatchedMovies() {
        Map<Long, Long> countMap = watchRepo.findAll().stream()
                .collect(Collectors.groupingBy(w -> w.getMovie().getMovieId(), Collectors.counting()));

        return countMap.entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(5)
                .map(e -> {
                    Movie m = movieRepo.findById(e.getKey()).orElse(null);
                    Map<String, Object> map = new HashMap<>();
                    map.put("movie", m);
                    map.put("watchCount", e.getValue());
                    return map;
                })
                .collect(Collectors.toList());
    }
}