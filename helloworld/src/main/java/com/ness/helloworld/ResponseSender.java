package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseSender {

    void send(String response, HttpExchange exchange, int statusCode) throws IOException {
        int responseLength = response.length();
        exchange.sendResponseHeaders(statusCode, responseLength);
        // TODO: This throws IO Exception - need to handle it?
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }

}
