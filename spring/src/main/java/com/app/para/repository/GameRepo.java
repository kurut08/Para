package com.app.para.repository;

import com.app.para.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepo extends JpaRepository<Game,Integer> {
    Optional<Game> findGameById(Integer id);
    @Query("SELECT g FROM Game g WHERE g.id = :id")
    Game findGameByGameId(Integer id);
}