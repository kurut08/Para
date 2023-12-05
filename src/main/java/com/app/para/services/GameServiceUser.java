package com.app.para.services;
import java.util.List;

import com.app.para.repository.GameRepoUser;
import com.app.para.models.GameUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceUser {
    @Autowired
    private GameRepoUser gameRepoUser;

    public void saveMyGames(GameUser game) {
        gameRepoUser.save(game);
    }

    public List<GameUser> getAllMyGames(){
        return gameRepoUser.findAll();
    }

    public void deleteById(int id) {
        gameRepoUser.deleteById(id);
    }
}
