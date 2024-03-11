package com.ashaselvaraj.order.service;

import com.ashaselvaraj.order.entity.OrderSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndReplaceOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId(){

        OrderSequence counter = mongoOperations.findAndModify(
                Query.query(where("_id").is(1)),
                new Update().inc("sequence",1),
               FindAndModifyOptions.options().returnNew(true).upsert(true),OrderSequence.class
       );

        //queries document with id = orderSequence update the field sequence= sequence+1. modified doc must be returned
        //if doc not present create one. enter the class name too
        return  counter.getSequence();
    }
}
