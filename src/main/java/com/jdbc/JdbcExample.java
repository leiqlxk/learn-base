package com.jdbc;

import java.sql.*;

/**
 * Title: JdbcExample <br>
 * ProjectName: learn-base <br>
 * description: jdbc基础样例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/11 10:33 <br>
 */
public class JdbcExample {

    public static void main(String[] args) {
        Connection connection = JdbcExample.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from sys_user";

        try {
            //关闭自动提交
            connection.setAutoCommit(false);

            //组装sql
            preparedStatement = connection.prepareStatement(sql);

            //查询结果
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("user_id");
                String name = resultSet.getString("login_name");
                System.out.println(id + "====" + name);
            }

            //提交事务
            connection.commit();
            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static Connection getConnection() {
        Connection connection = null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.10.90:3306/yhouse_test?zeroDateTimeBehavior=convertToNull";
            String userName = "root";
            String password = "gopro123";

            //获取连接
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
