package ClientPackage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;



public class Client {
	
	public static Socket socket = null;
	
	public static void main (String args[]) {
		
		BufferedReader in = null;
		PrintWriter out = null;
		
		String one = new String("1"); 
		String two = new String("2"); 
		String three = new String("3"); 
		int check = 0;
		
		
		try {
			socket = new Socket("localhost",786);
			System.out.println("Connected to server\n" + "socket" + socket.getInetAddress() + ":" + socket.getPort() + "\n" );
		}catch(IOException e){
			System.out.println("connection couldn't be esta3blished.");
		}
		
		
		
		try {
			
			in = new BufferedReader(new InputStreamReader(System.in) );
			
			System.out.println("Enter 1 for Rock");
			System.out.println("Enter 2 for Paper");
			System.out.println("Enter 3 for Scissors");
			System.out.println("Enter your choice:");
			String theString = in.readLine();
			
			
						
			if(theString.equals(one) || theString.equals(two) || theString.equals(three) )
				check=0;
			else
				check=1;
			
			
			
			if(check == 1) 
			{
				throw new Exception();
			}
			
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println(theString);
			
			
		}catch(Exception e) {
			System.out.println("You can only enter 1, 2 or 3.");
		}	
	}
}
