package com.ness.helloworld;

import java.util.stream.Collectors;

public class HttpResponseCreator {

    public HttpResponse handleGetNames(NameList nameList) {
       String reponse = nameList.getList().stream().collect(Collectors.joining(", "));
       return new HttpResponse(reponse, 200);
    }

    public HttpResponse handleDelete(String requestedPath, NameList nameList) {
        String name = requestedPath.split("/names/")[1];
        if (name.equalsIgnoreCase(nameList.getSeedName())) {
            return new HttpResponse("Cannot delete the seed name.", 405);
        }
        nameList.removeFromList(name);
        return new HttpResponse(name, 200);
    }

    public HttpResponse handlePost(NameList nameList, String requestBody) {
        String name = requestBody.split("=")[1];
        if(nameList.getList().contains(name)) {
            return new HttpResponse(name, 405);
        }
        nameList.addToNameList(name);
        return new HttpResponse(name, 201);
    }

    public HttpResponse handlePut(String requestedPath, NameList nameList, String requestBody) {
        String originalName = requestedPath.split("/names/")[1];
        if (nameList.getList().contains(originalName) && !originalName.equalsIgnoreCase(nameList.getSeedName())) {
            String newName = requestBody.split("=")[1];
            nameList.removeFromList(originalName);
            nameList.addToNameList(newName);
            return new HttpResponse(newName, 201);
        } else {
            return originalName.equalsIgnoreCase(nameList.getSeedName()) ? new HttpResponse("Cannot replace seed name.", 405) : new HttpResponse(originalName, 404);
        }
    }
}
