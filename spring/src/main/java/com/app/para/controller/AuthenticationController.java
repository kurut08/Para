package com.app.para.controller;

import com.app.para.models.*;
import com.app.para.services.GameService;
import com.app.para.services.GameLibraryService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.para.services.AuthService;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthService authenticationService;
    @Autowired
    private GameService gameService;
    @Autowired
    private GameLibraryService gameLibraryService;
    @PostMapping("/register_email")
    public String processRegister(@RequestBody RegistrationDTO body, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        authenticationService.register(body.getEmail(), body.getUsername(), body.getPassword(), getSiteURL(request));
        return "register_success";
    }
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getEmail(), body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/loginMess")
    public ResponseEntity<?> loginMessage(@RequestBody RegistrationDTO body){
        LoginMessage loginMessage = authenticationService.loginMessage(body.getUsername(), body.getPassword());
        return ResponseEntity.ok(loginMessage);
    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (authenticationService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
    @PostMapping("/addgame")
    public ResponseEntity<String> addGame(@RequestBody Game game){
        gameService.addGame(game.getTitle(), game.getDescription(), game.getPrice(), game.getGenre());
        return new ResponseEntity<>("Added game", HttpStatus.OK);
    }
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
        List<Game_Library>list= gameLibraryService.getAllMyGames();
        model.addAttribute("game",list);
        return "myGames";
    }
}
// TODO FIX MAPPING IN EVERY FUNCTION FOR USERS AND ADMIN