package com.app.para.services;
//USing BDD Mockito
import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.app.para.models.Game;
import com.app.para.repository.GameRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)

// Main class
class GameServiceTest {

    @Mock
    private GameRepo gameRepo;
    @InjectMocks
    private GameService gameService;

    @Test
    void getAllGames()
    {
        Game game01 = new Game("F1 23", "Wciśnij gaz do dechy w EA SPORTS™ F1® 23, oficjalnej grze wideo 2023 FIA Formula One World Championship™. Nowy rozdział w emocjonującym trybie fabularnym „Droga do sławy” to dramatyczna historia i zaciekła rywalizacja.", 55.99f, "Sports");
        Game game02 = new Game("EA SPORTS WRC", "Zbuduj samochód swoich marzeń w naszej największej grze rajdowej – EA SPORTS™ WRC. To zupełnie nowy, oficjalny tytuł FIA World Rally Championship, stworzony przez wielokrotnie nagradzany zespół stojący za serią DiRT Rally.", 66.99f, "Sports");
        given(gameRepo.findAll())
                .willReturn(List.of(game01,game02));
        var  gameList = gameService.getAllGames();
        assertThat(gameList).isNotNull();
        assertThat(gameList.size()).isEqualTo(2);
    }
}