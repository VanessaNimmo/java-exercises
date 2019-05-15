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
        NamesRouter namesRouter = new NamesRouter(new HttpResponseSender(), nameList, httpResponseCreator);
        RootRouterAndHandler rootRouterAndHandler = new RootRouterAndHandler(new GreetingFormatter(), nameList);
        server.createContext("/names", namesRouter);
        server.createContext("/", rootRouterAndHandler);
        server.setExecutor(null);
        server.start();
    }

    public static void stop() {
        server.stop(0);
    }
}
