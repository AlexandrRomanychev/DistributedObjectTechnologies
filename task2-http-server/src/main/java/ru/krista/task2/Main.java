package ru.krista.task2;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class Main {
    public static void main(String[] args) {
        Undertow server = Undertow.builder().addHttpListener(5000,
                "localhost").setHandler(exchange -> {
            exchange.getResponseHeaders()
                    .put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getResponseSender().send("Romanychev Alexandr");
        }).build();
        server.start();
    }
}
