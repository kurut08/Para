package com.app.para.repository;

import com.app.para.models.Game_Media;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameMediaRepo extends JpaRepository<Game_Media, Integer>
{
    Optional<Game_Media> findGameMediaById(Integer id);
}
