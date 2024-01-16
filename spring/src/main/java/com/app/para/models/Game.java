package com.app.para.models;

import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Float price;
    private String genre;
    @Column(columnDefinition = "TEXT")
    private String url;

    public Game(String title, String description, Float price, String genre) {
        super();
        this.title = title;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }

    public Game(int id, String title, String description, Float price, String genre, String url) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.url = url;
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

    public String getUrl() { return url; }
    public void setURL(String url) { this.url = url; }
}