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
import org.springframework.security.core.userdetails.UserDetails;
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
    private UserService userService;
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
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (authenticationService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
    @GetMapping("/shop")
    public ResponseEntity<List<Game>> getGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }
    @GetMapping("/shop/{gameId}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable Integer gameId){
        return new ResponseEntity<Optional<Game>>(gameService.findGameById(gameId), HttpStatus.OK);
    }
    @PostMapping("/buy/{userId}/{gameId}")
    public ResponseEntity<String> buyGame(@PathVariable Integer userId, @PathVariable Integer gameId){
        gameLibraryService.buyGame(userId, gameId);
        return new ResponseEntity<>("You've bought a game!", HttpStatus.OK);
    }
    @GetMapping("/library/{id}")
    public ResponseEntity<Optional<List<Game_Library>>> getMyGames(@PathVariable Integer id)
    {
        return new ResponseEntity<>(gameLibraryService.getAllMyGames(id), HttpStatus.OK);
    }
    @GetMapping("/reviews/{gameId}")
    public ResponseEntity<Optional<List<Game_Review>>> getReviews(@PathVariable Integer gameId){
        return new ResponseEntity<>(gameReviewService.findReviewsByGameId(gameId), HttpStatus.OK);
    }
    @RequestMapping("/user/createInvite")
    public ResponseEntity<String> createInvite(@RequestBody Invite invite){
        friendsService.createInvite(invite.getUserFrom(), invite.getUserTo());
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }
    @GetMapping("/user/inviteList/{id}")
    public ResponseEntity<Optional<List<Invite>>> getAllInvites(@PathVariable Integer id){
        return new ResponseEntity<>(friendsService.getAllInvites(id), HttpStatus.OK);
    }
    @PostMapping("/user/acceptInvite/{id}")
    public ResponseEntity<String> acceptInvite(@RequestBody Invite invite, boolean accept){
        friendsService.acceptInvite(invite, accept);
        return new ResponseEntity<>("Request made!", HttpStatus.OK);
    }
    @GetMapping("/user/friendList/{id}")
    public ResponseEntity<Optional<List<Friends>>> getFriends(@PathVariable Integer id){
        return new ResponseEntity<>(friendsService.getAllFriends(id), HttpStatus.OK);
    }
    @GetMapping("/user/deleteFriend/{id}")
    public ResponseEntity<String> deleteFriend(@PathVariable Integer id, @RequestBody ApplicationUser user){
        friendsService.deleteFriends(id, user.getUserId());
        return new ResponseEntity<>("Friend deleted!", HttpStatus.OK);
    }
    @GetMapping("/profile/{username}")
    public ResponseEntity<UserDetails> getProfile(@PathVariable String username){
        return new ResponseEntity<>(userService.loadUserByUsername(username), HttpStatus.OK);
    }
    @PostMapping("/admin/addGame")
    public ResponseEntity<String> addGame(@RequestBody Game game){
        gameService.addGame(game.getTitle(), game.getDescription(), game.getPrice(), game.getGenre());
        return new ResponseEntity<>("Added game", HttpStatus.OK);
    }
    @RequestMapping("/admin/deleteGame/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id")Integer id) {
        gameService.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}
// TODO FIX MAPPING IN EVERY FUNCTION FOR USERS AND ADMIN