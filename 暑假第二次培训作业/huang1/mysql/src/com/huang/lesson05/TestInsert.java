package com.huang.lesson05;

import com.huang.lesson02.utils.jdbcutils;
import com.huang.lesson05.utils.jdbcutils_dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestInsert {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement sta = null;

        try {
            con = jdbcutils_dbcp.getConnection();
            String sql = "INSERT into `users`(`id`,`NAME`,`email`,`birthday`) VALUES (?,?,?,?);";
            sta = con.prepareStatement(sql);
            sta.setInt(1, 5);
            sta.setString(2, "小亮");
            sta.setString(3, "123456@qq.com");
            sta.setDate(4, new java.sql.Date(new Date().getTime()));
            int i = sta.executeUpdate();
            if (i > 0) {
                System.out.println("成功了");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcutils_dbcp.Release(con, sta, null);
        }
    }
}

