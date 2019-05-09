package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;

public class Response {

    private String body;
    private int statusCode;
    private HttpExchange exchange;

    Response(String body, int statusCode, HttpExchange exchange) {
        this.body = body;
        this.statusCode = statusCode;
        this.exchange = exchange;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public HttpExchange getExchange() {
        return exchange;
    }
}
