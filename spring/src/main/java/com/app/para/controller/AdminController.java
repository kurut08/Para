package com.app.para.controller;

import com.app.para.models.Game;
import com.app.para.models.Game_Library;
import com.app.para.services.GameService;
import com.app.para.services.GameLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

}
// TODO DELETE THIS FILE AFTER MOVING THESE FUNCS TO AuthenticationController.java