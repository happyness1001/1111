package ln.dlut.ln.controller;

import org.springframework.remoting.support.DefaultRemoteInvocationExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {
    Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://192.168.74.176:3306/mysql?characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
        System.out.println(111);
        return connection;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conn c = new conn();
        c.getConnection();
    }
}
