package com.para.service;

import com.para.games.Game;
import com.para.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {
    private final GameRepo gameRepo;

    @Autowired
    public GameService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public Game addGame(Game game){
        game.setGameCode(UUID.randomUUID().toString());
        return gameRepo.save(game);
    }
    public List<Game> getGames(){
        return List.of(
                new Game(
                        1,
                        "Marvel SNAP",
                        4.99,
                        "best game eva",
                        2022
                )
        );
    }
}
