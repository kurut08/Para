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

    public void save(Game game) {
        gameRepo.save(game);
    }

    public List<Game> getAllGames(){
        return gameRepo.findAll();
    }

    public Optional<Game> findGameById(String id) {
        return gameRepo.findGameById(id);
    }
    public void deleteById(String id) {
        gameRepo.deleteById(id);
    }
}
