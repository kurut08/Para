package com.app.para.controller;

import com.app.para.models.*;
import com.app.para.repository.*;
import com.app.para.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationController.class)
public class ControllerTest {
    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    GameRepo gameRepo;
    @MockBean
    GameLibraryRepo gameLibraryRepo;
    @MockBean
    GameReviewRepo gameReviewRepo;
    @MockBean
    FriendsRepo friendsRepo;
    @MockBean
    InviteRepo inviteRepo;
    @MockBean
    private UserRepo userRepo;
    @MockBean
    private RoleRepo roleRepo;
    @MockBean
    AuthService authService;
    @MockBean
    GameService gameService;
    @MockBean
    private GameLibraryService gameLibraryService;
    @MockBean
    private FriendsService friendsService;
    @MockBean
    private UserService userService;
    @MockBean
    private GameReviewService gameReviewService;
    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void shop() throws Exception{
        List<Game> games = Arrays.asList(new Game("F1 23", "Wciśnij gaz do dechy w EA SPORTS™ F1® 23, oficjalnej grze wideo 2023 FIA Formula One World Championship™. Nowy rozdział w emocjonującym trybie fabularnym „Droga do sławy” to dramatyczna historia i zaciekła rywalizacja.", 55.99f, "Sports"),
        new Game("EA SPORTS WRC", "Zbuduj samochód swoich marzeń w naszej największej grze rajdowej – EA SPORTS™ WRC. To zupełnie nowy, oficjalny tytuł FIA World Rally Championship, stworzony przez wielokrotnie nagradzany zespół stojący za serią DiRT Rally.", 66.99f, "Sports"));
        when(gameService.getAllGames()).thenReturn(games);
        mockMvc.perform(get("/auth/shop").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(games))).andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void checkReview() throws Exception{
        Role userRole = roleRepo.save(new Role("USER")) ;
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        ApplicationUser user = new ApplicationUser(1, "user@user.pl", "user", "user", authorities);
        Game game = new Game(1, "EA SPORTS WRC", "Zbuduj samochód swoich marzeń w naszej największej grze rajdowej – EA SPORTS™ WRC. To zupełnie nowy, oficjalny tytuł FIA World Rally Championship, stworzony przez wielokrotnie nagradzany zespół stojący za serią DiRT Rally.", 66.99f, "Sports", "URL");
        Game_Review game_review = new Game_Review(1, true, "Super gra", user, game);
        gameReviewRepo.save(game_review);
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/reviews/1").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(game_review))).andExpect(status().isOk());
    }
}