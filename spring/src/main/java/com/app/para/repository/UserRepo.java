package com.app.para.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.para.models.ApplicationUser;

@Repository
public interface UserRepo extends JpaRepository<ApplicationUser, Integer> {
    @Query("SELECT u FROM ApplicationUser u WHERE u.username = :username")
    Optional<ApplicationUser> findByUsername(String username);
   @Query(name = ApplicationUser.FIND_BY_VERIFICATION_CODE)
    ApplicationUser findByVerificationCode(@Param("code") String code);
    Optional<ApplicationUser> findOneByUsernameAndPassword(String username, String password);
    @Query("SELECT f FROM ApplicationUser f WHERE f.userId = :id")
    ApplicationUser getUserById(Integer id);

    ApplicationUser findUserById(Integer userId);
}