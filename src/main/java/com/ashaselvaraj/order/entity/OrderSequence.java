package com.ashaselvaraj.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderSequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSequence {
    @Id
    private int id;
    private int sequence;
}
