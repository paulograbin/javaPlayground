module com.paulograbin.modules {

    requires java.net.http;
    requires java.logging;
    requires lwjgl;
    requires lwjgl.util;

    exports com.paulograbin.modules.sitecheck;
    exports com.paulograbin.modules.sitecheck.concurrent;

    exports com.paulograbin.openGL.javaGL;

}