package com.paulograbin.modules.sitecheck.internal;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class TrustEveryone implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static SSLContext context() throws NoSuchAlgorithmException, KeyManagementException {
        var trustEveryone = new TrustManager[]{new TrustEveryone()};
        var sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustEveryone, new SecureRandom());

        return sslContext;
    }
}
