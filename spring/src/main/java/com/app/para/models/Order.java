package com.app.para.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private ApplicationUser user;
    @OneToMany
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<Game> game;
    @Column(nullable = false)
    private Float price;
    @Column(nullable = false)
    private String date;

    public Order(ApplicationUser user, List<Game> game, Float price, String date){
        super();
        this.user=user;
        this.game=game;
        this.price=price;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
