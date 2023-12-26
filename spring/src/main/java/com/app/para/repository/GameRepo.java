package com.app.para.repository;

import com.app.para.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepo extends JpaRepository<Game,String> {
    Optional<Game> findGameById(String id);
}