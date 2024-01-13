package com.app.para.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="game_review")
public class Game_Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_review_id")
    private Integer id;
    @Column(name = "type", nullable = false)
    private Boolean type;
    @Column(name = "text")
    private String text;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private ApplicationUser user;

    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    public Game_Review() { super();}
    public Game_Review(Integer id, Boolean type)
    {
        super();
        this.id = id;
        this.type = type;
    }
    public Game_Review(Integer id, Boolean type, String text)
    {
        super();
        this.id = id;
        this.type = type;
        this.text = text;
    }

    public Integer getId() { return this.id; }
    public void setId(Integer gameReviewId) {this.id = gameReviewId; }

    public ApplicationUser getUser() { return this.user; }
    public void setUser(ApplicationUser user) { this.user = user; }

    public Game getGame() { return this.game; }
    public void setGame(Game game) { this.game = game; }
}
