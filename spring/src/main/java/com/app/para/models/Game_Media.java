package com.app.para.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="game_media")
public class Game_Media
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_media_id")
    private Integer id;
    @Column(nullable = false)
    private String url;

    public Game_Media() { super();}

    public Game_Media(String url)
    {
        super();
        this.url = url;
    }
    public Game_Media(Integer id, String url)
    {
        super();
        this.id = id;
        this.url = url;
    }

    public Integer getId() { return this.id; }
    public void setId(Integer gameMediaId) {this.id = gameMediaId; }

    public String getURL() { return this.url; }
    public void setURL(String URL) { this.url = url; }

}
