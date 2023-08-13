package com.huang.lesson06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import com.huang.lesson05.utils.jdbcutils_dbcp;

public class TestInsert {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement sta = null;

        try {
            con =jdbcutils_dbcp.getConnection();
            String sql1 = "insert into `huang`(`id`,`username`,`price`,`quantity`,`status`,`operation_time`) VALUES (?,?,?,?,?,?);";
            sta = con.prepareStatement(sql1);
            sta.setInt(1, 1);
            sta.setString(2, "小亮");
            sta.setFloat(3, 30);
            sta.setInt(4, 10);
            sta.setString(5,"Active");
            sta.setDate(6, new java.sql.Date(new Date().getTime()));
            int i = sta.executeUpdate();
            if (i > 0) {
                System.out.println("成功了");
            }
            String sql2 = "insert into `huang`(`id`,`username`,`price`,`quantity`,`status`,`operation_time`) VALUES (?,?,?,?,?,?);";
            sta = con.prepareStatement(sql2);
            sta.setInt(1, 2);
            sta.setString(2, "小明");
            sta.setFloat(3, 40);
            sta.setInt(4, 20);
            sta.setString(5,"inActive");
            sta.setDate(6, new java.sql.Date(new Date().getTime()));
            int i1 = sta.executeUpdate();
            if (i1 > 0) {
                System.out.println("成功了");
            }
            String sql3 = "insert into `huang`(`id`,`username`,`price`,`quantity`,`status`,`operation_time`) VALUES (?,?,?,?,?,?);";
            sta = con.prepareStatement(sql3);
            sta.setInt(1, 3);
            sta.setString(2, "小亮3");
            sta.setFloat(3, 80);
            sta.setInt(4, 20);
            sta.setString(5,"inActive");
            sta.setDate(6, new java.sql.Date(new Date().getTime()));
            int i3 = sta.executeUpdate();
            if (i3 > 0) {
                System.out.println("成功了");
            }
            String sql4= "insert into `huang`(`id`,`username`,`price`,`quantity`,`status`,`operation_time`) VALUES (?,?,?,?,?,?);";
            sta = con.prepareStatement(sql4);
            sta.setInt(1, 4);
            sta.setString(2, "小黄");
            sta.setFloat(3, 100);
            sta.setInt(4, 30);
            sta.setString(5,"Active");
            sta.setDate(6, new java.sql.Date(new Date().getTime()));
            int i4 = sta.executeUpdate();
            if (i4 > 0) {
                System.out.println("成功了");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcutils_dbcp.Release(con, sta, null);
        }
    }
}

