package com.app.para.repository;

import com.app.para.models.Friends;
import com.app.para.models.Game_Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendsRepo extends JpaRepository<Friends, Integer>
{
    Optional<Friends> findFriendsById(Integer id);
}
