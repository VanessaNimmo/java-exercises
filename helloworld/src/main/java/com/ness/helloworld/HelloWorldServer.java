package com.ness.helloworld;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HelloWorldServer {

    private static HttpServer server;
    private static NameList nameList;

    public static void main(String[] args) throws IOException {

        server = HttpServer.create(new InetSocketAddress(8080), 0);
        nameList = new NameList("Vanessa");
        HttpResponseCreator httpResponseCreator = new HttpResponseCreator();
        HttpResponseSender httpResponseSender = new HttpResponseSender();
        NamesRouter namesRouter = new NamesRouter(nameList, httpResponseCreator, httpResponseSender);
        RootRouterAndHandler rootRouterAndHandler = new RootRouterAndHandler(new GreetingFormatter(), nameList, httpResponseSender);
        server.createContext("/names", namesRouter);
        server.createContext("/", rootRouterAndHandler);
        server.setExecutor(null);
        server.start();
    }

    public static void stop() {
        server.stop(0);
    }
}
