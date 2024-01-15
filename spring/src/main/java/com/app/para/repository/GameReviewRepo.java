package com.app.para.repository;

import com.app.para.models.Game_Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface GameReviewRepo extends JpaRepository<Game_Review,Integer> {
    @Query("SELECT g FROM Game_Review g WHERE g.game.id = :id")
    Optional<List<Game_Review>> findReviewById(Integer id);
}