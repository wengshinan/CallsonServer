package com.cloud.son.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class DbUtil {
    private static class DbUtilHolder{
        private static final DbUtil db = new DbUtil();
    }

    private DbUtil() {
        dbDriver = PropertyUtil.getProperty(PropertyUtil.KEY_DB_DRIVER);
        dbUrl = PropertyUtil.getProperty(PropertyUtil.KEY_DB_URL);
        dbUser = PropertyUtil.getProperty(PropertyUtil.KEY_DB_USER);
        dbPassword = PropertyUtil.getProperty(PropertyUtil.KEY_DB_PASSWORD);

        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection conn;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String dbDriver;

    private Connection getConn(){
        return this.conn;
    }

    public static Connection getConnection() {
        return DbUtilHolder.db.getConn();
    }


}
