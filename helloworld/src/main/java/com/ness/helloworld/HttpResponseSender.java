package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class HttpResponseSender {

    void send(HttpResponse httpResponse, HttpExchange exchange) throws IOException {
        int responseLength = httpResponse.getBody().length();
        exchange.sendResponseHeaders(httpResponse.getStatusCode(), responseLength);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(httpResponse.getBody().getBytes());
        outputStream.close();
    }
}
