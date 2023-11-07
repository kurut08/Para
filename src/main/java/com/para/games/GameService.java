package com.para.games;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService {
    public List<Game> getGames(){
        return List.of(
                new Game(
                        1,
                        "Marvel SNAP",
                        4.99,
                        "best game eva",
                        2022
                )
        );
    }
}
