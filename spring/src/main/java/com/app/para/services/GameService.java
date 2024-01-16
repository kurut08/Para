package com.app.para.services;
import java.util.List;
import java.util.Optional;

import com.app.para.repository.GameRepo;
import com.app.para.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public Game addGame(String title, String description, Float price, String genres) {
        return gameRepo.save(new Game(title, description, price, genres));
    }

    public List<Game> getAllGames(){
        return gameRepo.findAll();
    }

    public Optional<Game> findGameById(Integer id) {
        return gameRepo.findGameById(id);
    }
    public void deleteById(Integer id) {
        gameRepo.deleteById(id);
    }
}
