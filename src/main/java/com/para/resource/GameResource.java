package com.para.resource;

import com.para.games.Game;
import com.para.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/games")
public class GameResource {
    private final GameService gameService;
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("all")
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.findAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Integer id){
        Game game = gameService.findGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Game> addGame(@RequestBody Game game){
        Game newGame = gameService.addGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Game> updateGame(@RequestBody Game game) {
        Game updateGame = gameService.updateGame(game);
        return new ResponseEntity<>(updateGame, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable("id") Integer id){
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

