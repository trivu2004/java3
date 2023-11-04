/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slide7;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Client");
        String sentence;
        String modifiedSentence;
        InetAddress inetAddress = Inet4Address.getLocalHost();
        BufferedReader inFromClient
                = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket(inetAddress.getHostName(), 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.print("Nhap chuoi ky tu: ");
        sentence = inFromClient.readLine();

        outToServer.writeBytes(sentence + '\n');

        modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();

    }
}
