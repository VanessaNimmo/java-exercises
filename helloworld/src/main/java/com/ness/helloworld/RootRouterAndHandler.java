package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class RootRouterAndHandler implements HttpHandler {

    private GreetingFormatter greetingFormatter;
    private ResponseSender responseSender;
    private NameList nameList;

    RootRouterAndHandler(GreetingFormatter formatter, ResponseSender sender, NameList list) {
        greetingFormatter = formatter;
        responseSender = sender;
        nameList = list;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
         String response = greetingFormatter.createResponse(LocalDateTime.now(), nameList);
         responseSender.send(response, exchange, 200);
    }
}
