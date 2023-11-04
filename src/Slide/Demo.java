/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {


       private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=lab1;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "trivu2004";

    public static void main(String[] args) {

        // Handle any errors that may have occurred.
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("thnah cong");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
