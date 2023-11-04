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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Server");
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));
            System.out.println("inFromClient: " + inFromClient);
            DataOutputStream outToClient = new DataOutputStream(
                    connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println("clientSentence: " + clientSentence);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
//            outToClient.writeBytes(capitalizedSentence);
            outToClient.writeBytes("Tau tra tien\n");
        }
//        System.out.println("chay den day chua");
    }
}
