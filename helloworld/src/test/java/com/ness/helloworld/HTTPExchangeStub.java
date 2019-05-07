package com.ness.helloworld;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class HTTPExchangeStub extends HttpExchange {

    private String requestMethod;
    private URI requestURI;

    HTTPExchangeStub(String requestMethod, URI requestURI) {
        this.requestMethod = requestMethod;
        this.requestURI = requestURI;
    }

    @Override
    public Headers getRequestHeaders() {
        return null;
    }

    @Override
    public Headers getResponseHeaders() {
        return null;
    }

    @Override
    public URI getRequestURI() {
        return this.requestURI;
    }

    @Override
    public String getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public HttpContext getHttpContext() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getRequestBody() {
        return null;
    }

    @Override
    public OutputStream getResponseBody() {
        return null;
    }

    @Override
    public void sendResponseHeaders(int rCode, long responseLength) throws IOException {

    }

    @Override
    public InetSocketAddress getRemoteAddress() {
        return null;
    }

    @Override
    public int getResponseCode() {
        return 0;
    }

    @Override
    public InetSocketAddress getLocalAddress() {
        return null;
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Override
    public void setStreams(InputStream i, OutputStream o) {

    }

    @Override
    public HttpPrincipal getPrincipal() {
        return null;
    }
}
