package com.app.para.services;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Role;
import com.app.para.repository.GameRepo;
import com.app.para.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public Game addGame(String title, String description, Float price, String genres) {
        return gameRepo.save(new Game(0, title, description, price, genres));
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
