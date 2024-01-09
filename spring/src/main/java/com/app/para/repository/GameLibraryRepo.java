package com.app.para.repository;

import com.app.para.models.Game_Library;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLibraryRepo extends JpaRepository<Game_Library,Integer> {
    Optional<Game_Library> findGameLibraryById(Integer id);

}
