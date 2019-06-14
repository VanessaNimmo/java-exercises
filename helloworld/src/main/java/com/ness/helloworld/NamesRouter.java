package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class NamesRouter implements HttpHandler {

    private NameList nameList;
    private HttpResponseCreator httpResponseCreator;
    private HttpResponseSender httpResponseSender;

    NamesRouter(NameList nameList, HttpResponseCreator httpResponseCreator, HttpResponseSender sender) {
        this.nameList = nameList;
        this.httpResponseCreator = httpResponseCreator;
        this.httpResponseSender = sender;
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
            try {
                String requestBody = getRequestBody(exchange);
                response = httpResponseCreator.handlePost(nameList, requestBody);
            } catch (NullPointerException e) {
                System.out.println("System error occured");
            }
        }
        if (requestMethod.equalsIgnoreCase("put")) {
            try {
                String requestBody = getRequestBody(exchange);
                response = httpResponseCreator.handlePut(requestedPath, nameList, requestBody);
            } catch (NullPointerException e) {
                System.out.println("System error occured");
            }
        }
        if (requestNotImplemented(requestMethod)) {
            response = new HttpResponse("Not implemented", 501);
        }
        httpResponseSender.send(response, exchange);
    }

    private String getRequestBody(HttpExchange exchange) throws NullPointerException {
        InputStream requestBodyStream = exchange.getRequestBody();
        return new BufferedReader(new InputStreamReader(requestBodyStream))
                .lines().collect(Collectors.joining("\n"));
    }

    private boolean requestNotImplemented(String requestMethod) {
        return (requestMethod.equalsIgnoreCase("head") ||
                requestMethod.equalsIgnoreCase("connect") ||
                requestMethod.equalsIgnoreCase("options") ||
                requestMethod.equalsIgnoreCase("trace") ||
                requestMethod.equalsIgnoreCase("patch"));
    }
}
