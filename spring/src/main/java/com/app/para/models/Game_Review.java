package com.app.para.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="game_review")
public class Game_Review implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_review_id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "rev_id", referencedColumnName = "id")
    private GLHelp glHelp;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private ApplicationUser user;
    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    public Game_Review() { super();}
    public Game_Review(GLHelp glHelp, ApplicationUser user, Game game)
    {
        super();
        this.glHelp=glHelp;
        this.user = user;
        this.game = game;
    }
    public Integer getId() { return this.id; }
    public void setId(Integer gameReviewId) {this.id = gameReviewId; }

    public ApplicationUser getUser() { return this.user; }
    public void setUser(ApplicationUser user) { this.user = user; }

    public Game getGame() { return this.game; }
    public void setGame(Game game) { this.game = game; }
}
