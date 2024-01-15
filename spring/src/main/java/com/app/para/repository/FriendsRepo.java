package com.app.para.repository;

import com.app.para.models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendsRepo extends JpaRepository<Friends, Integer>
{
    @Query("SELECT f FROM Friends f WHERE f.owner = :id")
    Optional<List<Friends>> findFriendsById(Integer id);
    @Query("DELETE FROM Friends f WHERE f.friend = :id AND f.owner = :idOwner")
    void deleteByOwnerId(Integer id, Integer idOwner);
}
