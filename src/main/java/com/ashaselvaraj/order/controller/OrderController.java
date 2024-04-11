package com.ashaselvaraj.order.controller;

import com.ashaselvaraj.order.dto.OrderDTO;
import com.ashaselvaraj.order.dto.OrderDTOFromFE;
import com.ashaselvaraj.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE){
        OrderDTO orderDTO = orderService.saveOrder(orderDTOFromFE);
        return  new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
