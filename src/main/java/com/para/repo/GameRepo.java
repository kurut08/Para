package com.para.repo;

import com.para.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepo extends JpaRepository<Game, Integer> {
}
