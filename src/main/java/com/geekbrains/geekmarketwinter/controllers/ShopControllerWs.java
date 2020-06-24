package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.entites.Greeting;
import com.geekbrains.geekmarketwinter.entites.Message;

public interface ShopControllerWs {
    void sendMessage(String destination, Greeting message);
    Message getMessage();
}
