package com.huang.lesson05.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcutils_dbcp {
    private static DataSource ds =null;
    static {

        try{
            InputStream in = jdbcutils_dbcp.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(in);
            ds= BasicDataSourceFactory.createDataSource(properties);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //加载链接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void Release(Connection con, Statement sta, ResultSet res){
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            con=null;
        }
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            sta =null;
        }
        if(res!=null) {
            try {
                res.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            res =null;
        }
    }
}

