package com.app.para.models;

import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String title;
    private String description;
    private Integer price;
    private String genre;

    public Game(int id, String title, String description, Integer price, String genre) {
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
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenres(String genre) {
        this.genre = genre;
    }
}