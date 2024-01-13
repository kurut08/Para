package com.app.para.repository;

import com.app.para.models.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InviteRepo extends JpaRepository<Invite, Integer>
{
    Optional<Invite> findInviteById(Integer id);
}