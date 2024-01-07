package com.app.para.models;

import jakarta.persistence.*;

@Entity
@Table(name="game_library")
public class Game_Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
}
