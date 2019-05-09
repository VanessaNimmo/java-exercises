package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class NamesHandler {

    public String handleGetNames(NameList nameList) {
       return nameList.getList().stream().collect(Collectors.joining(", "));
    }

    public String handleDelete(String requestedPath, NameList nameList) {
        String name = requestedPath.split("/names/")[1];
        nameList.removeFromList(name);
        return name;
    }

    public String handlePost(HttpExchange exchange, NameList nameList) {
        InputStream requestBodyStream = exchange.getRequestBody();
        String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                .lines().collect(Collectors.joining("\n"));
        String name = requestBody.split("=")[1];
        nameList.addToNameList(name);
        return name;
    }

    public String handlePut(String requestedPath, HttpExchange exchange, NameList nameList) {
        String originalName = requestedPath.split("/names/")[1];
        InputStream requestBodyStream = exchange.getRequestBody();
        String requestBody = new BufferedReader(new InputStreamReader(requestBodyStream))
                .lines().collect(Collectors.joining("\n"));
        String newName = requestBody.split("=")[1];
        nameList.removeFromList(originalName);
        nameList.addToNameList(newName);
        return "";
    }
}
