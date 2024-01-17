package com.app.para.services;

import com.app.para.models.GLHelp;
import com.app.para.models.Game_Review;
import com.app.para.repository.GLHelpRepo;
import com.app.para.repository.GameRepo;
import com.app.para.repository.GameReviewRepo;
import com.app.para.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameReviewService {
    @Autowired
    private GameReviewRepo gameReviewRepo;
    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GLHelpRepo glHelpRepo;

    public void addGameReview(Integer gameId, Integer userId, boolean bool, String text)
    {
        GLHelp glHelp = new GLHelp(bool, text);
        glHelpRepo.save(glHelp);
        gameReviewRepo.save(new Game_Review(glHelpRepo.findGLHelpById(glHelp.getId()), userRepo.findUserById(userId), gameRepo.findGameByGameId(gameId)));
    }

    public List<Game_Review> findByGameId(Integer gameId) {
        return gameReviewRepo.findByGameId(gameId);
    }


}