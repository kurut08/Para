package com.app.para.controller;

import com.app.para.models.*;
import com.app.para.services.*;
import com.app.para.services.TokenService;
import jakarta.mail.MessagingException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private AuthService authenticationService;
    @Autowired
    private GameService gameService;
    @Autowired
    private GameLibraryService gameLibraryService;
    @Autowired
    private FriendsService friendsService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private GameReviewService gameReviewService;
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
    @PreAuthorize("ADMIN")
    @PostMapping("/admin/addgame")
    public ResponseEntity<String> addGame(@RequestBody Game game){
        gameService.addGame(game.getTitle(), game.getDescription(), game.getPrice(), game.getGenre());
        return new ResponseEntity<>("Added game", HttpStatus.OK);
    }
    @GetMapping("/shop")
    public ResponseEntity<List<Game>> getGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }
    @GetMapping("/library/{id}")
    public ResponseEntity<Optional<Game_Library>> getMyGames(@PathVariable Integer id)
    {
        return new ResponseEntity<>(gameLibraryService.getAllMyGames(id), HttpStatus.OK);
    }
    @GetMapping("/shop/{gameId}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable String gameId, @RequestBody Game game){
        return new ResponseEntity<Optional<Game>>(gameService.findGameById(gameId), HttpStatus.OK);
    }
    @GetMapping("/reviews/{gameId}")
    public ResponseEntity<Optional<Game_Review>> getReviews(@PathVariable Integer gameId){
        return new ResponseEntity<>(gameReviewService.findGameReviewById(gameId), HttpStatus.OK);
    }
    @RequestMapping("/admin/deleteGame/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id")String id) {
        gameService.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
    @RequestMapping("/user/createInvite")
    public ResponseEntity<String> createInvite(@RequestBody Invite invite){
        friendsService.createInvite(invite.getInviteId(), invite.getUserFrom(), invite.getUserTo());
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }
    @GetMapping("/user/inviteList/{id}")
    public ResponseEntity<Optional<Invite>> getAllInvites(@PathVariable Integer id){
        return new ResponseEntity<>(friendsService.getAllInvites(id), HttpStatus.OK);
    }


}
// TODO FIX MAPPING IN EVERY FUNCTION FOR USERS AND ADMIN