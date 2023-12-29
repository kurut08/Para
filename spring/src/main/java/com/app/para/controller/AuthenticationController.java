package com.app.para.controller;

import com.app.para.models.LoginMessage;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.para.models.ApplicationUser;
import com.app.para.models.LoginResponseDTO;
import com.app.para.models.RegistrationDTO;
import com.app.para.services.AuthService;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthService authenticationService;
    @PostMapping("/register_email")
    public String processRegister(@RequestBody RegistrationDTO body, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        authenticationService.register(body.getEmail(), body.getUsername(), body.getPassword(), getSiteURL(request));
        return "register_success";
    }
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getEmail(), body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/loginMess")
    public ResponseEntity<?> loginMessage(@RequestBody RegistrationDTO body){
        LoginMessage loginMessage = authenticationService.loginMessage(body.getUsername(), body.getPassword());
        return ResponseEntity.ok(loginMessage);
    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (authenticationService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

}