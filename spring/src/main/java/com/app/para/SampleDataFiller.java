package com.app.para;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Game;
import com.app.para.models.Game_Library;
import com.app.para.models.Role;
import com.app.para.repository.GameLibraryRepo;
import com.app.para.repository.GameRepo;
import com.app.para.repository.RoleRepo;
import com.app.para.repository.UserRepo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SampleDataFiller
{
    public void FillDatabase(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode, GameRepo gameRepo, GameLibraryRepo gameLibraryRepo)
    {
        if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
        Role adminRole = roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        ApplicationUser admin = new ApplicationUser(1, "admin@admin.com","admin", passwordEncode.encode("admin"), roles);

        userRepository.save(admin);

        Game_Library gameLibrary = new Game_Library();

        String[] games = {"Satisfactory", "Firewatch", "Frostpunk", "Far Cry 5",
        "Detroid Become Human", "Baldur's Gate 3", "Rust", "Factory Town Idle",
        "Melvor Idle", "Rainbow Six Siege", "Call of Duty: WWII", "Company of Heroes",
        "Company of Heroes 2", "Company of Heroes 3", "Dragon Age: Origins - Ultimate Edition",
        "Dragon Age II: Ultimate Edition", "Dragon Age Inquisition", "Yes, Your Grace",
        "Mass Effect Legendary Edition", "Mass Effect: Andromeda Deluxe Edition"};
        String[] descriptions = {
          "Satisfactory is a first-person open-world factory building game with a dash of exploration and combat. Play alone or with friends, explore an alien planet, create multi-story factories, and enter conveyor belt heaven!",
                "Firewatch is a single-player first-person mystery set in the Wyoming wilderness, where your only emotional lifeline is the person on the other end of a handheld radio.",
                "Frostpunk is the first society survival game. As the ruler of the last city on Earth, it is your duty to manage both its citizens and infrastructure. What decisions will you make to ensure your society's survival? What will you do when pushed to breaking point? Who will you become in the process?",
                "Discover the open world of Hope County, Montana, besieged by a fanatical doomsday cult. Dive into the action solo or two-player co-op in the story campaign, use a vast arsenal of weapons and allies, and free Hope County from Joseph Seed and his cult.",
                "Detroit: Become Human puts the destiny of both mankind and androids in your hands, taking you to a near future where machines have become more intelligent than humans. Every choice you make affects the outcome of the game, with one of the most intricately branching narratives ever created.",
                "Baldur’s Gate 3 is a story-rich, party-based RPG set in the universe of Dungeons & Dragons, where your choices shape a tale of fellowship and betrayal, survival and sacrifice, and the lure of absolute power.",
                "The only aim in Rust is to survive. Everything wants you to die - the island’s wildlife and other inhabitants, the environment, other survivors. Do whatever it takes to last another night.",
                "An entire town builder experience packed into a living spreadsheet. Build housing, assign workers, then craft and sell a huge variety of items to level up your town and expand your civilization across the world!",
                "Inspired by RuneScape, Melvor Idle takes the core of what makes an adventure game so addictive and strips it down to its purest form! This is a feature-rich, idle/incremental game combining a distinctly familiar feel with a fresh gameplay experience. Maxing 20+ skills has never been more zen.",
                "Tom Clancy's Rainbow Six® Siege is an elite, tactical team-based shooter where superior planning and execution triumph.",
                "Call of Duty® returns to its roots with Call of Duty®: WWII - a breathtaking experience that redefines World War II for a new gaming generation.",
                "Delivering a visceral WWII gaming experience, Company of Heroes redefines RTS by bringing the sacrifice of heroic soldiers, war-ravaged environments, and dynamic battlefields to life. Please visit the Company of Heroes - Legacy Edition page for additional user reviews.",
                "Experience the ultimate WWII RTS platform with COH2 and its standalone expansions. This package includes the base game, which you can then upgrade by purchasing The Western Front Armies, Ardennes Assault and/or The British Forces. More info in the About This Game section below.",
                "Bigger and better than ever, Company of Heroes 3 combines heart-pounding combat with deeper strategic choices in a stunning Mediterranean theatre of war. In Company of Heroes 3, every battle tells a story...what's yours?",
                "You are a Grey Warden, one of the last of this legendary order of guardians. With the return of mankind's ancient foe and the kingdom engulfed in civil war, you have been chosen by fate to unite the shattered lands and slay the archdemon once and for all. Explore a stunning world, make complex moral choices, and engage in bone-crushing combat against massive and terrifying creatures.",
                "You are Hawke, a refugee seeking to escape the darkspawn-plagued land of Ferelden and become Champion of Kirkwall. Rise to power and fight epic battles while making decisions that determine the course of civilization.",
                "Winner of over 130 Game of the Year awards, discover the definitive Dragon Age: Inquisition experience. The Game of the Year Edition includes the critically acclaimed game, all three official add-ons - Jaws of Hakkon, The Descent, and Trespasser - and more.",
                "These are troubling times, Your Grace. The petitioners’ petty matters exceed our limited resources, to say nothing of the war. A careful balance must be struck. Your throne awaits.",
                "The Mass Effect™ Legendary Edition includes single-player base content and over 40 DLC from the highly acclaimed Mass Effect, Mass Effect 2, and Mass Effect 3 games, including promo weapons, armors, and packs — remastered and optimized for 4K Ultra HD.",
                "Return to the Mass Effect universe & lead the first humans in Andromeda on a desperate search for our new home."
        };
        Float[] prices = {29.99f, 19.99f, 29.99f, 59.99f, 39.99f, 59.99f, 39.99f, 3.49f, 9.99f, 7.99f, 59.99f, 19.99f, 19.99f, 59.99f, 29.99f, 29.99f, 39.99f, 19.99f, 59.99f, 39.99f};
        String[] genres = {"Base building", "Adventure", "City builder", "FPS", "Adventure", "RPG", "Survival", "Idle", "Idle", "FPS", "FPS", "Strategy", "Strategy", "Strategy",
        "RPG", "RPG", "RPG", "Adventure", "RPG", "RPG"};
        String[] links = {
                "https://cdn.akamai.steamstatic.com/steam/apps/526870/header.jpg?t=1701857353",
                "https://cdn.akamai.steamstatic.com/steam/apps/383870/header.jpg?t=1688484486",
                "https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1701879213",
                "https://cdn.akamai.steamstatic.com/steam/apps/552520/header.jpg?t=1694554810",
                "https://cdn.akamai.steamstatic.com/steam/apps/1222140/header.jpg?t=1667468479",
                "https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1703250718",
                "https://cdn.akamai.steamstatic.com/steam/apps/252490/header.jpg?t=1701938429",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2207490/header.jpg?t=1705005734",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1267910/header.jpg?t=1700624451",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/359550/header.jpg?t=1703177325",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/476600/header.jpg?t=1646764749",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/228200/header.jpg?t=1694787032",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/231430/header.jpg?t=1661158807",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1677280/header.jpg?t=1704821735",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/47810/header.jpg?t=1615244558",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1238040/header.jpg?t=1671830944",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1222690/header.jpg?t=1668811031",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1115690/header.jpg?t=1702905882",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1328670/header.jpg?t=1669773470",
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1238000/header.jpg?t=1661437203"
        };

        int[] steamId = {526870,383870, 323190, 552520, 1222140, 1086940, 252490, 2207490, 1267910, 359550, 476600,
                228200, 231430, 1677280, 47810, 1238040, 1222690, 1115690, 1328670, 1238000};

        Game game;
        for(int i = 0; i < 20; i++)
        {
            game = new Game(i+1, games[i], descriptions[i], prices[i], genres[i], links[i], steamId[i]);
            gameRepo.save(game);

            if(i == 10 || i == 11)
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.now();
                String date = localDateTime.format(formatter);
                gameLibrary = new Game_Library(admin, game, date);
                gameLibraryRepo.save(gameLibrary);

            }
        }
    }
}
