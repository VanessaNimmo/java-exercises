package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class RootRouterAndHandler implements HttpHandler {

    private GreetingFormatter greetingFormatter;
    private NameList nameList;
    private HttpResponseSender httpResponseSender;

    RootRouterAndHandler(GreetingFormatter greetingFormatter, NameList nameList, HttpResponseSender httpResponseSender) {
        this.greetingFormatter = greetingFormatter;
        this.nameList = nameList;
        this.httpResponseSender = httpResponseSender;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ZoneId zoneId = ZoneId.of("Australia/Sydney");
        ZonedDateTime zonedTime = ZonedDateTime.now(zoneId);
         String responseBody = greetingFormatter.createFormattedGreeting(zonedTime, nameList);
         HttpResponse response = new HttpResponse(responseBody, 200);
         httpResponseSender.send(response, exchange);
    }
}
