/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide7;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author USER
 */
public class Demo2 {

    public static void main(String[] args) throws UnknownHostException {
        try {
            InetAddress [] address = InetAddress.getAllByName("dantri.com.vn");
            for (int i = 0; i < address.length; i++) {
                System.out.println("Address "+(i+1)+": "+address[i]);
            }
        } catch (Exception e) {
        }

    }
}
