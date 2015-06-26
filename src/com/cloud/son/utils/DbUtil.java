package com.cloud.son.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class DbUtil {
    private static DbUtil db = null;

    private DbUtil() throws IOException, ClassNotFoundException, SQLException{
        dbDriver = PropertyUtil.getProperty(PropertyUtil.KEY_DB_DRIVER);
        dbUrl = PropertyUtil.getProperty(PropertyUtil.KEY_DB_URL);
        dbUser = PropertyUtil.getProperty(PropertyUtil.KEY_DB_USER);
        dbPassword = PropertyUtil.getProperty(PropertyUtil.KEY_DB_PASSWORD);

        Class.forName(dbDriver);
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    private Connection conn;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String dbDriver;

    public Connection getConn(){
        return this.conn;
    }

    public static Connection getConnection() {
        if (null == db) {
            try {
                db = new DbUtil();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return db.getConn();
    }


}
