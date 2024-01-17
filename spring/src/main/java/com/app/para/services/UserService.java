package com.app.para.services;

import com.app.para.models.ApplicationUser;
import com.app.para.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("UserDetails");
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not found user"));
    }
    public ApplicationUser getUserById(Integer id){
        return userRepo.getUserById(id);
    }
    public List<ApplicationUser> getAllUsers(){
        return userRepo.findAll();
    }
}
