package com.app.para.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="game_library")
public class Game_Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private ApplicationUser user;

    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    public Game_Library() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Game_Library(int id) {
        super();
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ApplicationUser getUser() { return this.user; }
    public void setUser(ApplicationUser user) { this.user = user; }

    public Game getGame() { return this.game; }
    public void setGame(Game game) { this.game = game; }
}
