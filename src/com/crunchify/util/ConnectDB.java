package com.crunchify.util;

public class ConnectDB extends DataSourceConfig {
    public void makeConnection(String db) throws Exception {
        this.conn = getDataSource(db);
    }
}
