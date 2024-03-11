package com.ashaselvaraj.order.entity;

import com.ashaselvaraj.order.dto.FoodItemDTO;
import com.ashaselvaraj.order.dto.RestaurantDTO;
import com.ashaselvaraj.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private RestaurantDTO restaurantDTO;
    private UserDTO userDTO;
}