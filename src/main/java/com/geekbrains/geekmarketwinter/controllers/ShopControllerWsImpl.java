package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.entites.Greeting;
import com.geekbrains.geekmarketwinter.entites.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShopControllerWsImpl implements ShopControllerWs{
    private Message message;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(Message message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting(message.getName() + " добавлен в коризну!");
//    }


    public Message getMessage() {
        return message;
    }

    @MessageMapping("/hello")
    public void receiveEvent(Message message) {
        this.message = message;
        System.out.println(message);
    }

    public void sendMessage(String destination, Greeting message) {
        simpMessagingTemplate.convertAndSend(destination, message);
    }
}
