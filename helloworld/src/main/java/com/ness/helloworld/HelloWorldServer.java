package com.ness.helloworld;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HelloWorldServer {

    private static HttpServer server;

    public static void main(String[] args) throws IOException {

        server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RequestHandler(new GreetingFormatter(), new ResponseSender()));
        server.setExecutor(null);
        server.start();
    }

    public static void stop() {
        server.stop(0);
    }
}
