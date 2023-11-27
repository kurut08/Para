package com.app.para.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameServiceUser gameServiceUser;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/game_add")
    public String bookAdd() {
        return "gameadd";
    }

    @GetMapping("/available_game")
    public ModelAndView getAllBook() {
        List<Game> list= gameService.getAllGames();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        return new ModelAndView("gameList","game",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Game game) {
        gameService.save(game);
        return "redirect:/available_game";
    }
    @GetMapping("/my_games")
    public String getMyGames(Model model)
    {
        List<GameUser>list= gameServiceUser.getAllMyGames();
        model.addAttribute("game",list);
        return "myGames";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Game game = gameService.getGameById(id);
        GameUser gameUser = new GameUser(game.getId(),game.getTitle(),game.getDescription(),game.getPrice(), game.getImageUrl());
        gameServiceUser.saveMyGames(gameUser);
        return "redirect:/my_games";
    }

    @RequestMapping("/editGame/{id}")
    public String editGame(@PathVariable("id") int id,Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("game",game);
        return "gameEdit";
    }
    @RequestMapping("/deleteGame/{id}")
    public String deleteGame(@PathVariable("id")int id) {
        gameService.deleteById(id);
        return "redirect:/available_games";
    }

}