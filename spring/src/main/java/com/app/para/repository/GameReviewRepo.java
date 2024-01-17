package com.app.para.repository;

import com.app.para.models.Game;
import com.app.para.models.Game_Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface GameReviewRepo extends JpaRepository<Game_Review,Integer> {
    @Query("SELECT gr FROM Game_Review gr, GLHelp gl, Game gm, ApplicationUser au WHERE gr.game.id = :id AND gr.glHelp = gl.id AND gr.user = au.id")
    List<Game_Review> findByGameId(Integer id);

    List<Game_Review> findGame_ReviewByGameId(Integer gameId);
    //@Query("SELECT g.id, g.text, g.type, g.game, g.user FROM Game_Review g WHERE g.game.id = :gameId")
    List<Game_Review> findTextByGameId(Integer gameId);
}