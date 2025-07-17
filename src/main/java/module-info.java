module com.paulograbin.modules {

    requires java.sql;
    requires mysql.connector.java;
    requires java.net.http;
    requires java.logging;
    requires java.desktop;
    requires hibernate.jpa;
    requires hibernate.core;

    exports com.paulograbin.modules.sitecheck;
    exports com.paulograbin.modules.sitecheck.concurrent;

    opens com.paulograbin.SimpleCRUD to hibernate.core;

}