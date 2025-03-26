package com.paulograbin.modules.sitecheck;

import com.paulograbin.modules.sitecheck.concurrent.ParallelHTTPChecker;
import com.paulograbin.modules.sitecheck.internal.PushHTTPChecker;
import com.paulograbin.modules.sitecheck.internal.TrustEveryone;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


public class SiteCheck implements HTTPChecker {

    private final HttpClient client;

    public SiteCheck(HttpClient client) {
        this.client = client;
    }

    private static void usage() {
        System.err.println("Usage: HttpCheck <URL>");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            usage();

            var location = args[0];

            var mode = "sync";
            if (args.length > 1) {
                mode = args[1];
            }

            try {
                var sslContext = TrustEveryone.context();

                var client = HttpClient.newBuilder()
                        .sslContext(sslContext)
                        .build();
                HTTPChecker checker = null;

                if (mode.equals("sync")) {
                    checker = new SiteCheck(client);
                } else if (mode.equals("async")) {
                    checker = new ParallelHTTPChecker(client);
                } else if (mode.equals("push")) {
                    checker = new PushHTTPChecker(client);
                } else {
                    usage(); // Doesn't return
                }
                checker.check(location);

            } catch (URISyntaxException e) {
                System.err.println("Location: " + location + " is not valid");
                usage();
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                System.err.println("Crypo error: ");
                e.printStackTrace();
            } catch (InterruptedException e) {
                System.err.println("Contacting " + location + " interruped:");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Contacting " + location + " failed:");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void check(String location) throws IOException, URISyntaxException, InterruptedException {
        var uri = new URI(location);
        var req = HttpRequest.newBuilder(uri).build();

        var response = client.send(req, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));

        System.out.println(location + ": " + response.version());
    }
}
