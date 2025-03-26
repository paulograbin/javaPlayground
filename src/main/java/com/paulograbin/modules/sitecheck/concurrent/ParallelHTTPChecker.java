package com.paulograbin.modules.sitecheck.concurrent;

import com.paulograbin.modules.sitecheck.HTTPChecker;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ParallelHTTPChecker implements HTTPChecker {

    private final HttpClient client;

    public ParallelHTTPChecker(HttpClient client) {
        this.client = client;
    }

    @Override
    public void check(String location) throws IOException, URISyntaxException, InterruptedException {
        var uri = new URI(location);
        var req = HttpRequest.newBuilder(uri).build();

        var handler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture.allOf(
                client.sendAsync(req, handler).thenAccept((stringHttpResponse -> System.out.println("First"))),
                client.sendAsync(req, handler).thenAccept((stringHttpResponse -> System.out.println("Second"))),
                client.sendAsync(req, handler).thenAccept((stringHttpResponse -> System.out.println("Third")))
        ).join();
    }

}
