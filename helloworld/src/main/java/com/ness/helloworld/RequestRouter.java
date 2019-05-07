package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class RequestRouter implements HttpHandler {

    private GreetingFormatter greetingFormatter;
    private NameList nameList;
    private ResponseSender responseSender;

    RequestRouter() {
        greetingFormatter = new GreetingFormatter();
        nameList = new NameList();
        responseSender = new ResponseSender();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestedPath = exchange.getRequestURI().toString();
        String response = "";
        if (requestMethod.equals("POST")) {
            InputStream requestBodyStream = exchange.getRequestBody();
            String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                    .lines().collect(Collectors.joining("\n"));
            String name = requestBody.split("=")[1];
            nameList.addToNameList(name);
            response = name;
        }
        if (requestMethod.equals("GET") && requestedPath.contains("/names")) {
            response = nameList.getList().stream().collect(Collectors.joining(", "));
        }
        responseSender.send(response, exchange);

    }
}
