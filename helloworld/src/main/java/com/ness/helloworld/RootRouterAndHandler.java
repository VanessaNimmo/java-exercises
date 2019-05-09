package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class RootRouterAndHandler implements HttpHandler {

    private GreetingFormatter greetingFormatter;
    private HttpResponseSender httpResponseSender;
    private NameList nameList;

    RootRouterAndHandler(GreetingFormatter formatter, HttpResponseSender sender, NameList list) {
        greetingFormatter = formatter;
        httpResponseSender = sender;
        nameList = list;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
         String responseBody = greetingFormatter.createResponse(LocalDateTime.now(), nameList);
         HttpResponse response = new HttpResponse(responseBody, 200);
         HttpResponseSender.send(response, exchange);
    }
}
