package com.app.para.repository;

import com.app.para.models.Game_Library;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLibraryRepo extends JpaRepository<Game_Library,Integer> {
    Optional<Game_Library> findGame_LibraryById(Integer id);
    @Query("SELECT g FROM Game_Library g WHERE g.user.id = :id")
    Optional<List<Game_Library>> findGame_LibraryByUserId(@Param("id") Integer id);

}
