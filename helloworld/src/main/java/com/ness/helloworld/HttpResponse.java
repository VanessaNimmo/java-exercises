package com.ness.helloworld;

class HttpResponse implements IResponse {

    private final String body;
    private final int statusCode;

    HttpResponse(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return body;
    }
}
