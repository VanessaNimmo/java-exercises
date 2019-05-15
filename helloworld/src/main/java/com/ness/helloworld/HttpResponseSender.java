package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class HttpResponseSender implements IResponseSender {

    static void send(HttpResponse httpResponse, HttpExchange exchange) throws IOException {
        int responseLength = httpResponse.getMessage().length();
        exchange.sendResponseHeaders(httpResponse.getStatusCode(), responseLength);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(httpResponse.getMessage().getBytes());
        outputStream.close();
    }

    @Override
    public void send(IResponse response, OutputStream output) {

    }
}
