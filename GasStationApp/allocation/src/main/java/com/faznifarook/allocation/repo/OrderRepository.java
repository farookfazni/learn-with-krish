package com.faznifarook.allocation.repo;

import com.faznifarook.allocation.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
