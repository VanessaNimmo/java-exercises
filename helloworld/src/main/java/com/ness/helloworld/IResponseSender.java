package com.ness.helloworld;

import java.io.OutputStream;

public interface IResponseSender {

    void send(IResponse response, OutputStream output);
}
