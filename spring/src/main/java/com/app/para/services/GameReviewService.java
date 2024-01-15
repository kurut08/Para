package com.app.para.services;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Game;
import com.app.para.models.Game_Review;
import com.app.para.repository.GameReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GameReviewService {
    @Autowired
    private GameReviewRepo gameReviewRepo;

    public Game_Review addGameReview(Integer id, boolean bool, String text)
    {
        return gameReviewRepo.save(new Game_Review(id, bool, text));
    }

    public Optional<Game_Review> findGameReviewById(Integer id)
    {
        return gameReviewRepo.findReviewById(id);
    }}