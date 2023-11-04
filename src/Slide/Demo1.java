/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide7;

import java.net.InetAddress;

/**
 *
 * @author USER
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            InetAddress myHost = InetAddress.getLocalHost();
            System.out.println("Host address: "+myHost.getHostAddress());
            System.out.println("Host name: "+myHost.getHostName());
        } catch (Exception e) {
        }
    }
}
