package com.netflixtracker.netflix_tracker;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory, Long> {
    List<WatchHistory> findByUserUserId(Long userId);
    List<WatchHistory> findByMovieMovieId(Long movieId);
}