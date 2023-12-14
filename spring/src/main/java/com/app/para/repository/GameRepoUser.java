package com.app.para.repository;

import com.app.para.models.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepoUser extends JpaRepository<GameUser,Integer> {

}
