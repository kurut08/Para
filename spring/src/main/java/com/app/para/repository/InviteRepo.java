package com.app.para.repository;

import com.app.para.models.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InviteRepo extends JpaRepository<Invite, Integer>
{
    @Query("SELECT i FROM Invite i WHERE i.userTo = :id")
    Optional<List<Invite>> findInviteById(Integer id);
}