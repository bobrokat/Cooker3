package com.itis.bobrinskaya.repository;

import com.itis.bobrinskaya.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ekaterina on 29.04.2016.
 */
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o where o.status = false ")
    List<Orders> findNotReady();

    @Query("select o from Orders o where o.status = true ")
    List<Orders> findReady();

    @Query("select max(o.id) from Orders o where o.user.id = :id")
    int findUsersLastOrder(@Param("id") int id);
}
