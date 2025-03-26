package com.paulograbin.modules.sitecheck;

import java.io.IOException;
import java.net.URISyntaxException;

public interface HTTPChecker {

    void check(String location) throws IOException, URISyntaxException, InterruptedException;

}
