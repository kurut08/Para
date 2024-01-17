package com.app.para.repository;

import com.app.para.models.GLHelp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GLHelpRepo extends JpaRepository<GLHelp, Integer> {
    GLHelp findGLHelpById(Integer id);
}
