package ServerPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.util.Random; 


public class Server {
	private static ServerSocket server = null; 
	private static Socket socket = null; 
	private static final int port = 786;
	
	public static void main(String args[]) {
		BufferedReader in = null;
		PrintWriter out = null;
		String theStringAtS ="";
		int r;
		
		
		
		try {
			System.out.println("Server is starting ...");
			server = new ServerSocket(port);
			System.out.println("Server has started");
		}catch(IOException e){
			System.out.println("Can not listen to port: " + port); 
			System.exit(-1);
		}
		
		
		
		try {
			socket = server.accept();
			System.out.println("Client has been connected\n");
		}catch(IOException e){
			System.out.println("Communication Error with client");
			System.exit(-1);
		}
		
		
		
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			theStringAtS = in.readLine();
		}catch(IOException e){
			System.out.println("Error.");
			System.out.println("Client could not be connected.");
			e.printStackTrace();
		}
		
		
		
		Random rand = new Random();
		r = rand.nextInt(3)+1;
		
		
		
		Integer result = Integer.valueOf(theStringAtS);		
		
		
		
		if(result == 1)
		{
			System.out.println("You are ROCK");
		}
		else if(result == 2)
		{
			System.out.println("You are PAPER");
		}
		else
		{
			System.out.println("You are SCISSORS");
		}
		
	
		
		if(r == 1)
		{
			System.out.println("And server is ROCK");
		}
		else if(r == 2)
		{
			System.out.println("And server is PAPER");
		}
		else
		{
			System.out.println("And server is SCISSORS");
		}
		
		
		
		if(result == r) 
		{
			System.out.println("Draw");	
		}
		else if((result == 1 && r == 2)||(result == 2 && r == 3)||(result == 3 && r == 1))
		{
			System.out.println("You lose.");
			System.out.println("Server wins.");
		}
		else
		{
			System.out.println("You win.");
			System.out.println("Server loses.");
			
		}	
	}
}
