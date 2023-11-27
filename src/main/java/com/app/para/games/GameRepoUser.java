package com.app.para.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepoUser extends JpaRepository<GameUser,Integer> {

}
