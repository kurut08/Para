package com.app.para.services;
import java.util.List;

import com.app.para.repository.GameLibraryRepo;
import com.app.para.models.Game_Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameLibraryService
{
    @Autowired
    private GameLibraryRepo gameRepoUser;

    public void saveMyGames(Game_Library game) {
        gameRepoUser.save(game);
    }

    public List<Game_Library> getAllMyGames(){
        return gameRepoUser.findAll();
    }

    public void deleteById(int id) {
        gameRepoUser.deleteById(id);
    }
}
