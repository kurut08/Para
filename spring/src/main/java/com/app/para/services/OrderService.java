package com.app.para.services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Game;
import com.app.para.models.Order;
import com.app.para.repository.GameLibraryRepo;
import com.app.para.models.Game_Library;
import java.util.Optional;

import com.app.para.repository.GameRepo;
import com.app.para.repository.OrderRepo;
import com.app.para.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private UserRepo userRepo;

    public void newOrder(String userId, List<String> gamesId){
        Integer userIdInt = Integer.valueOf(userId);
        List<Integer> gameIdInt = new ArrayList<>();
        for (int i = 0; i < gamesId.size(); i++) {
            gameIdInt.add(i, Integer.valueOf(gamesId.get(i)));
        }
        float price = 0f;
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < gamesId.size(); i++) {
            games.add(i, gameRepo.findGameByGameId(gameIdInt.get(i)));
        }
        for (Game game : games) {
            price = price + game.getPrice();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        orderRepo.save(new Order(userRepo.getUserById(userIdInt), games, price, localDateTime.format(formatter)));
    }
    public Optional<List<Order>> getAllMyOrders(Integer id){
        return orderRepo.findOrdersByUserId(id);
    }

}
