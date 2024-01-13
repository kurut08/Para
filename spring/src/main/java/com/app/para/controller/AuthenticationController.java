package com.app.para.controller;

import com.app.para.models.*;
import com.app.para.services.FriendsService;
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
    @Autowired
    private FriendsService friendsService;
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
    @PostMapping("/admin/addgame")
    public ResponseEntity<String> addGame(@RequestBody Game game){
        gameService.addGame(game.getTitle(), game.getDescription(), game.getPrice(), game.getGenre());
        return new ResponseEntity<>("Added game", HttpStatus.OK);
    }
    @GetMapping("/shop")
    public ResponseEntity<List<Game>> getGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }
    @GetMapping("/shop/{gameId}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable String gameId, @RequestBody Game game){
        return new ResponseEntity<Optional<Game>>(gameService.findGameById(gameId), HttpStatus.OK);
    }
    //@RequestMapping("/admin/editGame/{id}")
    //public ResponseEntity<Optional<Game>> editGame(@PathVariable("id") String id, @RequestBody Game game) {
        //String edit = gameService.findGameById(id);

    //}
    @RequestMapping("/admin/deleteGame/{id}")
    public String deleteGame(@PathVariable("id")String id) {
        gameService.deleteById(id);
        return "deleted";
    }
    @GetMapping("/user/mygames")
    public String getMyGames(Model model)
    {
        List<Game_Library>list= gameLibraryService.getAllMyGames();
        model.addAttribute("game",list);
        return "myGames";
    }
    @GetMapping("/user/friendList")
    public ResponseEntity<List<Friends>> getAllFriends() {
        return new ResponseEntity<>(friendsService.getAllFriends(), HttpStatus.OK);
    }
    @RequestMapping("/user/createInvite")
    public ResponseEntity<String> createInvite(@RequestBody Invite invite){
        friendsService.createInvite(invite.getInviteId(), invite.getUserFrom(), invite.getUserTo());
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }
    @RequestMapping("/user/acceptInvite")
    public ResponseEntity<String> acceptInvite(@RequestBody Invite invite, boolean accept){
        friendsService.acceptInvite(invite, accept);
        return new ResponseEntity<>("Accepted/Declined", HttpStatus.OK);
    }
    @GetMapping("/user/inviteList")
    public ResponseEntity<List<Invite>> getAllInvites(){
        return new ResponseEntity<>(friendsService.getAllInvites(), HttpStatus.OK);
    }


}
// TODO FIX MAPPING IN EVERY FUNCTION FOR USERS AND ADMIN