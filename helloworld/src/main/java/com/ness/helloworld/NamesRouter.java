package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class NamesRouter implements HttpHandler {

    private NameList nameList;
    private HttpResponseSender httpResponseSender;
    private HttpResponseCreator httpResponseCreator;

    NamesRouter(HttpResponseSender httpResponseSender, NameList nameList, HttpResponseCreator httpResponseCreator) {
        this.httpResponseSender = httpResponseSender;
        this.nameList = nameList;
        this.httpResponseCreator = httpResponseCreator;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestedPath = exchange.getRequestURI().toString();
        routeNames(exchange, requestedPath);
    }

    private void routeNames(HttpExchange exchange, String requestedPath) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        HttpResponse response = new HttpResponse("Internal server error.", 500);
        if (requestMethod.equalsIgnoreCase("get")) {
            response = httpResponseCreator.handleGetNames(nameList);
        }
        if (requestMethod.equalsIgnoreCase("delete")) {
            response = httpResponseCreator.handleDelete(requestedPath, nameList);
        }
        if (requestMethod.equalsIgnoreCase("post")) {
            String requestBody = getRequestBody(exchange);
            response = httpResponseCreator.handlePost(nameList, requestBody);
        }
        if (requestMethod.equalsIgnoreCase("put")) {
            String requestBody = getRequestBody(exchange);
            response = httpResponseCreator.handlePut(requestedPath, nameList, requestBody);
        }
        HttpResponseSender.send(response, exchange);
    }

    private String getRequestBody(HttpExchange exchange) {
        InputStream requestBodyStream = exchange.getRequestBody();
        String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                .lines().collect(Collectors.joining("\n"));
        return requestBody;
    }
}
