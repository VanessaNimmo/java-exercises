package com.ness.helloworld;

import java.io.IOException;
import java.io.OutputStream;

public class HttpResponseSender {

    void send(HttpResponse httpResponse) throws IOException {
        int responseLength = httpResponse.getBody().length();
        httpResponse.getExchange().sendResponseHeaders(httpResponse.getStatusCode(), responseLength);
        OutputStream outputStream = httpResponse.getExchange().getResponseBody();
        outputStream.write(httpResponse.getBody().getBytes());
        outputStream.close();
    }

}
