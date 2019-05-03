package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class ResponseHandler implements HttpHandler {

    private ResponseCreator responseCreator;
    private NameList nameList;

    ResponseHandler() {
        responseCreator = new ResponseCreator();
        nameList = new NameList();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if (method.equals("POST")) {
            InputStream requestBodyStream = exchange.getRequestBody();
            String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                    .lines().collect(Collectors.joining("\n"));
            String name = requestBody.split("=")[1];
            nameList.addToNameList(name);
            int responseLength = name.length();
            exchange.sendResponseHeaders(200, responseLength);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(name.getBytes());
            outputStream.close();

        } else {
            String response = responseCreator.createResponse(LocalDateTime.now(), this.nameList);
            int responseLength = response.length();
            exchange.sendResponseHeaders(200, responseLength);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }

    }
}
