package com.app.para.controller;

import com.app.para.models.*;
import com.app.para.repository.*;
import com.app.para.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
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
    public void login() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        Role adminRole = roleRepo.save(new Role("ADMIN"));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        ApplicationUser admin = new ApplicationUser(1, "admin@admin.com","admin", passwordEncoder.encode("admin"), roles);
        userRepo.save(admin);
        Map<String,String> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "admin");
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void shop() throws Exception{
        List<Game> games = Arrays.asList(new Game("F1 23", "Wciśnij gaz do dechy w EA SPORTS™ F1® 23, oficjalnej grze wideo 2023 FIA Formula One World Championship™. Nowy rozdział w emocjonującym trybie fabularnym „Droga do sławy” to dramatyczna historia i zaciekła rywalizacja.", 55.99f, "Sports"),
        new Game("EA SPORTS WRC", "Zbuduj samochód swoich marzeń w naszej największej grze rajdowej – EA SPORTS™ WRC. To zupełnie nowy, oficjalny tytuł FIA World Rally Championship, stworzony przez wielokrotnie nagradzany zespół stojący za serią DiRT Rally.", 66.99f, "Sports"));
        when(gameService.getAllGames()).thenReturn(games);
        mockMvc.perform(MockHttpServletRequestBuilder.get(("/auth/shop").cont
                .andExpect(status().isOk());
    }
}
https://www.youtube.com/watch?v=XASyDbfQYaw