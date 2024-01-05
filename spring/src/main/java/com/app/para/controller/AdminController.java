package com.app.para.controller;

import com.app.para.models.Game;
import com.app.para.models.GameUser;
import com.app.para.services.GameService;
import com.app.para.services.GameServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private GameService gameService;

    @Autowired
    private GameServiceUser gameServiceUser;

    @GetMapping("/shop")
    public ResponseEntity<List<Game>> getGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }
    @GetMapping("/shop/{gameId}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable String gameId){
        return new ResponseEntity<Optional<Game>>(gameService.findGameById(gameId), HttpStatus.OK);
    }
    @RequestMapping("/editGame/{id}")
    public String editGame(@PathVariable("id") String id, Model model) {
        //Game game = gameService.getGameById(id);
        //model.addAttribute("game",game);
        return "gameEdit";
    }
    @RequestMapping("/deleteGame/{id}")
    public String deleteGame(@PathVariable("id")String id) {
        gameService.deleteById(id);
        return "deleted";
    }

    @GetMapping("/mygames")
    public String getMyGames(Model model)
    {
        List<GameUser>list= gameServiceUser.getAllMyGames();
        model.addAttribute("game",list);
        return "myGames";
    }
}
// TODO DELETE THIS FILE AFTER MOVING THESE FUNCS TO AuthenticationController.java