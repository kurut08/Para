package com.app.para.services;
import java.util.List;

import com.app.para.repository.GameLibraryRepo;
import com.app.para.models.Game_Library;
import java.util.Optional;
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

    public Optional<Game_Library> getAllMyGames(Integer id){
        return gameRepoUser.findGame_LibraryByUserId(id);
    }

    public void deleteById(int id) {
        gameRepoUser.deleteById(id);
    }
}
