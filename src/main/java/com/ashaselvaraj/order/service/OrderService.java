package com.ashaselvaraj.order.service;

import com.ashaselvaraj.order.dto.OrderDTO;
import com.ashaselvaraj.order.dto.OrderDTOFromFE;
import com.ashaselvaraj.order.dto.UserDTO;
import com.ashaselvaraj.order.entity.Order;
import com.ashaselvaraj.order.mapper.OrderMapper;
import com.ashaselvaraj.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    OrderRepo orderRepo;
    SequenceGenerator sequenceGenerator;
    RestTemplate restTemplate;

    @Autowired
    public void setOderRepo(OrderRepo oderRepo) {
         this.orderRepo = oderRepo;
     }
    @Autowired
    public void setSequenceGenerator(SequenceGenerator sequenceGenerator) {   this.sequenceGenerator = sequenceGenerator;}
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) { this.restTemplate = restTemplate;}

    public OrderDTO saveOrder(OrderDTOFromFE orderDTOFromFE) {

        int orderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsForUserId(orderDTOFromFE.getUserId());
        Order order = new Order(orderId,orderDTOFromFE.getFoodItemDTOList(),orderDTOFromFE.getRestaurantDTO(),userDTO);
        orderRepo.save(order);
        return OrderMapper.Instance.getOrderDtoFromOrder(order);
    }

    private UserDTO fetchUserDetailsForUserId(Integer userId) {
        return restTemplate
                .getForObject("http://User-Service/user/fetchUserById/"+userId,
                UserDTO.class);
    }
}
