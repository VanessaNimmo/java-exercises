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

    RequestRouter(GreetingFormatter formatter, ResponseSender sender) {
        greetingFormatter = formatter;
        nameList = new NameList();
        responseSender = sender;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestedPath = exchange.getRequestURI().toString();
        String response = "";
        int statusCode = 200;
        if (requestMethod.equalsIgnoreCase("delete")) {
            String name = requestedPath.split("=")[1];
            nameList.removeFromList(name);
            response = name;
        }
        if (requestMethod.equalsIgnoreCase("post")) {
            InputStream requestBodyStream = exchange.getRequestBody();
            String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                    .lines().collect(Collectors.joining("\n"));
            String name = requestBody.split("=")[1];
            nameList.addToNameList(name);
            response = name;
        }
        if (requestMethod.equalsIgnoreCase("get") && requestedPath.contains("/names")) {
            response = nameList.getList().stream().collect(Collectors.joining(", "));
        } else if (requestMethod.equalsIgnoreCase("get")) {
            response = greetingFormatter.createResponse(LocalDateTime.now(), nameList);
        }
        responseSender.send(response, exchange, statusCode);
    }



}
