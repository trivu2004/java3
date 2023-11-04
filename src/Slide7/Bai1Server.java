/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class Bai1Server {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8998);
            System.out.println("Server is connecting....");
            Socket socket = serverSocket.accept();
            System.out.println("Server is connected");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                double number1 = inputStream.readDouble();
                double number2 = inputStream.readDouble();
                System.out.println("2 số nhận được từ Bai1Client là: " + number1 + " " + number2);
                double sum = number1 + number2;
                outputStream.writeDouble(sum);
                outputStream.flush();
                System.out.println("Tổng của 2 số là: " + sum);
                if (number1 == 0) {
                    if (number2 == 0) {
                        System.out.println("Phương trình có vô số nghiệm.");
                    } else {
                        System.out.println("Phương trình vô nghiệm.");
                    }
                } else {
                    double x = -number2 / number1;
                    System.out.println("Nghiệm của phương trình là x = " + x);
                }
            }
        } catch (Exception e) {
        }
    }
}
