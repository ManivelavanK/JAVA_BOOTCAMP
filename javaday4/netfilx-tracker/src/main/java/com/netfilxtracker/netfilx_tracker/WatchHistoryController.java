package com.netflixtracker.netflix_tracker;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class WatchHistoryController {

    private final WatchHistoryRepository repo;
    private final UserRepository userRepo;
    private final MovieRepository movieRepo;

    public WatchHistoryController(WatchHistoryRepository repo, UserRepository userRepo, MovieRepository movieRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.movieRepo = movieRepo;
    }

    @PostMapping
    public WatchHistory addWatch(@RequestBody WatchHistoryRequest req) {
        User u = userRepo.findById(req.userId()).orElseThrow();
        Movie m = movieRepo.findById(req.movieId()).orElseThrow();
        WatchHistory w = new WatchHistory();
        w.setUser(u);
        w.setMovie(m);
        w.setRating(req.rating());
        return repo.save(w);
    }

    @GetMapping("/user/{id}")
    public List<WatchHistory> byUser(@PathVariable Long id) {
        return repo.findByUserUserId(id);
    }

    @GetMapping("/movie/{id}")
    public List<WatchHistory> byMovie(@PathVariable Long id) {
        return repo.findByMovieMovieId(id);
    }

    record WatchHistoryRequest(Long userId, Long movieId, Integer rating) {}
}