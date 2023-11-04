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
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1TPCClient {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Client is connecting....");
            Socket socKet = new Socket("localhost", 8998);
            System.out.println("Client is connected");
            DataOutputStream outputStream = new DataOutputStream(socKet.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socKet.getInputStream());
            while (true) {
                System.out.println("Nhập vào số thứ 1: ");
                double a = sc.nextDouble();
                outputStream.writeDouble(a);
                outputStream.flush();
                System.out.println("Nhập vào số thứ 2: ");
                double b = sc.nextDouble();
                outputStream.writeDouble(b);
                outputStream.flush();
                double sum = inputStream.readDouble();
                System.out.println("Tổng của 2 số là: " + sum);
                if (a == 0) {
                    if (b == 0) {
                        System.out.println("Phương trình có vô số nghiệm.");
                    } else {
                        System.out.println("Phương trình vô nghiệm.");
                    }
                } else {
                    double x = -b / a;
                    System.out.println("Nghiệm của phương trình là x = " + x);
                }
                System.out.println("Tiếp tục? (y/n): ");
                String traloi = sc.next();
                if (traloi.equalsIgnoreCase("n")) {
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}
