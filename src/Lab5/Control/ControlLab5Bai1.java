/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5.Control;

import Lab5.Bai1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class ControlLab5Bai1 {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Lab5Bai1";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    
}
