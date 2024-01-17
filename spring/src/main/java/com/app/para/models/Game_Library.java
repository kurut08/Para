package com.app.para.models;

import jakarta.persistence.*;


@Entity
@Table(name="game_library")
@Access(value=AccessType.FIELD)
public class Game_Library{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private ApplicationUser user;

    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    private String date;

    public Game_Library() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Game_Library(ApplicationUser user, Game game, String date) {
        super();
        this.user = user;
        this.game = game;
        this.date = date;
    }
    public long getId() {
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
