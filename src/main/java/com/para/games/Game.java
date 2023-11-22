package com.para.games;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String title;
    private double price;
    private String description;
    private Integer year;
    private String imageUrl;

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    private String gameCode;

    public Game() {
    }
    public Game(Integer id, String title, double price, String description, Integer year, String imageUrl) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString(){
        return "Game{"+
                "id = "+id+'\''+
                "title = "+title+'\''+
                "price = "+price+'\''+
                "description = "+description+'\''+
                "year = "+year+'\''+
                "imageUrl = "+imageUrl+'\''+
                "}";
    }
}
