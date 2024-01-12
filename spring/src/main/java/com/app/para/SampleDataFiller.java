package com.app.para;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Game_Media;
import com.app.para.models.Role;
import com.app.para.repository.GameMediaRepo;
import com.app.para.repository.RoleRepo;
import com.app.para.repository.UserRepo;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SampleDataFiller
{
    public void FillDatabase(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode, GameMediaRepo gameMediaRepo)
    {
        if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
        Role adminRole = roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        ApplicationUser admin = new ApplicationUser(1, "admin@admin.com","admin", passwordEncode.encode("admin"), roles);

        Game_Media defaultGameMedia = new Game_Media(1, "https://fastly.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U");
        gameMediaRepo.save(defaultGameMedia);
        userRepository.save(admin);
    }
}
