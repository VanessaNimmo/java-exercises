package com.ness.helloworld;

public class HttpResponse {

    private String body;
    private int statusCode;

    HttpResponse(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
