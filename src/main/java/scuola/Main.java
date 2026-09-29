package scuola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        Socket mySocket = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        PrintWriter out = new PrintWriter(mySocket.getOutputStream(),true);
        
        do{
            String parola = in.readLine();
            if(parola.equals("exit")) break;
            System.out.println(parola.toUpperCase());
            out.println(parola.toUpperCase());
        }while(true);
        mySocket.close();
        ss.close();
    }
}