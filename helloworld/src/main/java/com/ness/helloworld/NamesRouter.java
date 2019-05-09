package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class NamesRouter implements HttpHandler {

    private NameList nameList;
    private ResponseSender responseSender;
    private NamesHandler namesHandler;

    NamesRouter(ResponseSender responseSender, NameList nameList, NamesHandler namesHandler) {
        this.responseSender = responseSender;
        this.nameList = nameList;
        this.namesHandler = namesHandler;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestedPath = exchange.getRequestURI().toString();
        routeNames(exchange, requestedPath);
    }

    private void routeNames(HttpExchange exchange, String requestedPath) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String response = "";
        int statusCode = 200;
        if (requestMethod.equalsIgnoreCase("get")) {
            response = namesHandler.handleGetNames(nameList);
        }
        if (requestMethod.equalsIgnoreCase("delete")) {
            response = namesHandler.handleDelete(requestedPath, nameList);
        }
        if (requestMethod.equalsIgnoreCase("post")) {
            response = namesHandler.handlePost(exchange, nameList);
        }
        if (requestMethod.equalsIgnoreCase("put")) {
            // TODO: How does PUT work? How do you send a response with no body?
            response = namesHandler.handlePut(requestedPath, exchange, nameList);
            statusCode = 201;
        }
        responseSender.send(response, exchange, statusCode);
    }

}
