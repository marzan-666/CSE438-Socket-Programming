/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author LIB-604
 */
public class Client1 {
    public static Socket socket = null;
    public static void main(String[] args) 
    { try 
    { socket = new Socket("localhost", 8080); 
    System.out.println("Connected to Server\n" + "Socket: " + socket.getInetAddress() + ":" + socket.getPort() + "\n" ); } catch (IOException e) { System.out.print("Connection to network can not be stablished"); }
    BufferedReader in = null;
    PrintWriter out = null; 
    Scanner consoleInput = new Scanner(System.in);
try {
    
//Prepared by Tousif Osman
    in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
    out = new PrintWriter(socket.getOutputStream(), true);
    System.out.println("Server: " + in.readLine()); 
    System.out.print("Client: your name_ "); out.println(consoleInput.nextLine());
while(true) 
{ 
    System.out.print("Server: "); System.out.println(in.readLine()); System.out.print("Client: "); out.println(consoleInput.nextLine()); }
} catch(IOException e){
    
    e.printStackTrace();
}
}
} 
    
