package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.*;
import com.vrubizha.eduspace.service.FriendRequestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;

@RestController
@Slf4j
public class FriendRequestController {

    private static final Logger logger=LoggerFactory.getLogger(FriendRequestController.class);
    private final FriendRequestService friendRequestService;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public FriendRequestController(FriendRequestService friendRequestService, AmqpTemplate amqpTemplate) {
        this.friendRequestService = friendRequestService;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping("/emit")
    public ResponseEntity<FriendRequest> createFriendRequest(){
        Account account=new Account(1,234321,"PRO",new Date(),"status",
                12,new BigInteger("570"),new Student(),new Parent(),new Teacher(),null);
        FriendRequest friendRequest=new FriendRequest(
                1,1,null,"PRO",null
        );
        friendRequestService.createFriendRequest(friendRequest);
        amqpTemplate.convertAndSend("queue1",friendRequest);
        return new ResponseEntity<>(friendRequest,HttpStatus.CREATED);
    }

}
