package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class NamesRouter implements HttpHandler {

    private NameList nameList;
    private HttpResponseSender httpResponseSender;
    private NamesHandler namesHandler;

    NamesRouter(HttpResponseSender httpResponseSender, NameList nameList, NamesHandler namesHandler) {
        this.httpResponseSender = httpResponseSender;
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
        String responseBody = "";
        int statusCode = 200;
        if (requestMethod.equalsIgnoreCase("get")) {
            responseBody = namesHandler.handleGetNames(nameList);
        }
        if (requestMethod.equalsIgnoreCase("delete")) {
            responseBody = namesHandler.handleDelete(requestedPath, nameList);
        }
        if (requestMethod.equalsIgnoreCase("post")) {
            responseBody = namesHandler.handlePost(exchange, nameList);
        }
        if (requestMethod.equalsIgnoreCase("put")) {
            responseBody = namesHandler.handlePut(requestedPath, exchange, nameList);
            statusCode = 201;
        }
        HttpResponse response = new HttpResponse(responseBody, statusCode, exchange);
        httpResponseSender.send(response);
    }

}
