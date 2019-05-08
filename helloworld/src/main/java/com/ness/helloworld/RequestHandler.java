package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class RequestHandler implements HttpHandler {

    private GreetingFormatter greetingFormatter;
    private NameList nameList;
    private ResponseSender responseSender;

    RequestHandler(GreetingFormatter formatter, ResponseSender sender) {
        greetingFormatter = formatter;
        nameList = new NameList();
        responseSender = sender;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestedPath = exchange.getRequestURI().toString();
        String response = "";
        int statusCode = 200;
        if (requestedPath.contains("/names")) {
            // TODO: problem here is you can't change the status code
           response = handleNames(exchange, requestedPath);
        } else if (requestedPath.equals("/")){
            response = handleRoot();
        }
        responseSender.send(response, exchange, statusCode);
    }

    private String handleRoot() {
        return greetingFormatter.createResponse(LocalDateTime.now(), nameList);
    }

    private String handleNames(HttpExchange exchange, String requestedPath) {
        String requestMethod = exchange.getRequestMethod();
        String response = "";
        if (requestMethod.equalsIgnoreCase("get")) {
            return handleGetNames();
        }
        if (requestMethod.equalsIgnoreCase("delete")) {
            response = handleDelete(requestedPath);
        }
        if (requestMethod.equalsIgnoreCase("post")) {
            InputStream requestBodyStream = exchange.getRequestBody();
            String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                    .lines().collect(Collectors.joining("\n"));
            String name = requestBody.split("=")[1];
            nameList.addToNameList(name);
            response = name;
        }
        return response;
    }

    private String handleDelete(String requestedPath) {
        String name = requestedPath.split("/names/")[1];
        nameList.removeFromList(name);
        return name;
    }

    private String handleGetNames() {
        return nameList.getList().stream().collect(Collectors.joining(", "));
    }

}
