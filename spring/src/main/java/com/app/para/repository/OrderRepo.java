package com.app.para.repository;

import com.app.para.models.Game_Library;
import com.app.para.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    Optional<Order> findOrderById(Integer id);
    @Query("SELECT g FROM Order g WHERE g.user.id = :id")
    Optional<List<Order>> findOrdersByUserId(@Param("id") Integer id);
}