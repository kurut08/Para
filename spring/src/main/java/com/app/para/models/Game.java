package com.app.para.models;

import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private Float price;
    private String genre;


    @OneToOne
    @JoinColumn(name = "game_media_id", referencedColumnName = "game_media_id")
    private Game_Media game_media;

    public Game(int id, String title, String description, Float price, String genre) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenres(String genre) {
        this.genre = genre;
    }

    public Game_Media getGameMedia() { return this.game_media; }
    public void setGameMedia(Game_Media game_media) { this.game_media = game_media; }
}