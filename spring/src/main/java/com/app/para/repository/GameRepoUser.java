package com.app.para.repository;

import com.app.para.models.Game_Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepoUser extends JpaRepository<Game_Library,Integer> {

}
