package com.para.repo;

import com.para.games.Game;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Integer> {
    void deleteGameById(Integer id);
    Optional<Game> findGameById(Integer id);
}
