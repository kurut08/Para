package com.app.para.services;
import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Role;
import com.app.para.repository.RoleRepo;
import com.app.para.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)

// Main class
class UserServiceTest {
    @Mock
    private UserRepo userRepo;
    @Mock
    private RoleRepo roleRepo;
    @InjectMocks
    private UserService userService;

    @Test
    void getAllUsers()
    {
        Role adminRole = roleRepo.save(new Role("ADMIN"));
        Role userRole = roleRepo.save(new Role("USER")) ;
        Set<Role> authorities = new HashSet<>();
        Set<Role> authorities02 = new HashSet<>();
        authorities.add(adminRole);
        authorities02.add(userRole);
        ApplicationUser user01 = new ApplicationUser(1, "user@admin.com","user", "user", authorities);
        ApplicationUser user02 = new ApplicationUser(2, "user0000@admin.com","user02", "kasztan", authorities02);

        given(userRepo.findAll())
                .willReturn(List.of(user01,user02));
        var  userList = userService.getAllUsers();
        assertThat(userList.get(0).getAuthorities()).isEqualTo(authorities);
        assertThat(userList.get(1).getUsername()).isEqualTo("user02");
    }
}