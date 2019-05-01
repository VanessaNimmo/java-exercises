package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

public class ResponseHandler implements HttpHandler {

    private ResponseCreator responseCreator;

    ResponseHandler() {
        responseCreator = new ResponseCreator();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = responseCreator.createResponse(LocalDateTime.now());
        exchange.sendResponseHeaders(200, 0);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
