package com.ashaselvaraj.order.repo;

import com.ashaselvaraj.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order,Integer> {
}
