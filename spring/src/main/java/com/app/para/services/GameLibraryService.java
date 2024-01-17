package com.app.para.services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.app.para.repository.GameLibraryRepo;
import com.app.para.models.Game_Library;
import java.util.Optional;

import com.app.para.repository.GameRepo;
import com.app.para.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameLibraryService
{
    @Autowired
    private GameLibraryRepo gameRepoUser;
    private Game_Library gameLibrary;
    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private UserRepo userRepo;

    public void saveMyGames(Game_Library game) {
        gameRepoUser.save(game);
    }

    public void buyGame(Integer userId, Integer gameID){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(formatter);
        gameLibrary = new Game_Library(userRepo.getUserById(userId), gameRepo.findGameByGameId(gameID), date);
        gameRepoUser.save(gameLibrary);
    }
    public Optional<List<Game_Library>> getAllMyGames(Integer id){
        return gameRepoUser.findGame_LibraryByUserId(id);
    }

    public void deleteById(int id) {
        gameRepoUser.deleteById(id);
    }
}
