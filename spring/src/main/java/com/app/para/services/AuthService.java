package com.app.para.services;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.app.para.models.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.para.repository.RoleRepo;
import com.app.para.repository.UserRepo;
import java.util.Random;
@Service
@Transactional
public class AuthService {

    private UserRepo userRepository;

    private RoleRepo roleRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    private JavaMailSender mailSender;
    Random random = new Random();

    public AuthService(UserRepo userRepository, RoleRepo roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.mailSender = mailSender;
    }

    public void register(String email, String username, String password, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(password);
        String randomCode = String.valueOf(random.nextInt(100000,999999));
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        ApplicationUser applicationUser = new ApplicationUser(0, email, username, encodedPassword, authorities);
        applicationUser.setVerificationCode(randomCode);
        applicationUser.setEnabled(false);
        userRepository.save(applicationUser);
        sendVerificationEmail(applicationUser, siteURL);
    }
    private void sendVerificationEmail(ApplicationUser applicationUser, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String fromAddress = "NoReply@spoko.pl";
        String senderName = "PaRa";
        String subject = "VeRyFiCaTiOn";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_blank\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "PaRa.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(applicationUser.getEmail());
        helper.setSubject(subject);
        content = content.replace("[[name]]", applicationUser.getUsername());
        String verifyURL = siteURL + "/verify?code=" + applicationUser.getVerificationCode();
        verifyURL = verifyURL.replace("8080", "3000");
        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }
    public boolean verify(String verificationCode) {
        ApplicationUser user = userRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return true;
        }

    }
    public ApplicationUser registerUser(String email, String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0, email, username, encodedPassword, authorities));
    }
    public LoginMessage loginMessage(String username, String password) {
        String msg = "";
        Optional<ApplicationUser> applicationUser = userRepository.findByUsername((username));
        if (applicationUser.isPresent()) {
            String encodedPassword = applicationUser.get().getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<ApplicationUser> user = userRepository.findOneByUsernameAndPassword(username, encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exits", false);
        }
    }
    public LoginResponseDTO loginUser(String username, String password){
        try{
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = tokenService.generateJwt(auth);
            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }
    }

}