package com.ashaselvaraj.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private RestaurantDTO restaurantDTO;
    private UserDTO userDTO;
}