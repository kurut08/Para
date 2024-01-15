package com.app.para.controller;

import com.app.para.models.Game;
import com.app.para.models.Game_Library;
import com.app.para.services.GameService;
import com.app.para.services.GameLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private GameService gameService;

    @Autowired
    private GameLibraryService gameLibraryService;
    @GetMapping("/game_add")
    public String gameAdd() {
        return "gameadd";
    }

    @GetMapping("/")
    public ModelAndView getAllGames() {
        List<Game> list= gameService.getAllGames();
		ModelAndView m=new ModelAndView();
		m.setViewName("gameList");
		m.addObject("game",list);
        return new ModelAndView("gameList","game",list);
    }
}
// TODO DELETE THIS FILE AFTER MOVING THESE FUNCS TO AuthenticationController.java