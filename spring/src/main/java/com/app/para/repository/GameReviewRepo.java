package com.app.para.repository;

import com.app.para.models.Game_Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GameReviewRepo extends JpaRepository<Game_Review,Integer> {
    Optional<Game_Review> findReviewById(Integer id);
}