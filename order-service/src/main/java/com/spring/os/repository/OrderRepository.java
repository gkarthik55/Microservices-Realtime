package com.spring.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.os.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>  
{
}
