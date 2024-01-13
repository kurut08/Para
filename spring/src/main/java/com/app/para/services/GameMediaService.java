package com.app.para.services;

import com.app.para.models.Game_Media;
import com.app.para.repository.GameMediaRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameMediaService
{
    @Autowired
    private GameMediaRepo gameMediaRepo;

    public Game_Media addGameMedia(Integer id, String url)
    {
        return gameMediaRepo.save(new Game_Media(id, url));
    }

    public Optional<Game_Media> findGameMediaById(Integer id)
    {
        return gameMediaRepo.findGameMediaById(id);
    }
}
