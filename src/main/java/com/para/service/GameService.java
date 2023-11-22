package com.para.service;

import com.para.exception.UserNotFoundException;
import com.para.games.Game;
import com.para.repo.GameRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
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
    public List<Game> findAllGames(){
        return gameRepo.findAll();
    }
    public Game updateGame(Game game){
        return gameRepo.save(game);
    }
    public void deleteGame(Integer id){
        gameRepo.deleteGameById(id);
    }
    public Game findGameById(Integer id){
        return gameRepo.findGameById(id).orElseThrow(() -> new UserNotFoundException("User by id "+id+ " was not found"));
    }
}
