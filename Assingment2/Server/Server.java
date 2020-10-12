package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class Server{

	public Server() {
		
	}
	
	static LinkedList<clientThread> clients = new LinkedList<>();
	

	
	public static void main(String[] args) {
		
		
		try {
			ServerSocket serverSocket =  new ServerSocket(8000);
			System.out.println("MathCham Game !!!");
			System.out.println("Game Server Started" + " (Press any key to start the game) ");
			
			
			new Thread(){
				
				public void run(){
				
					super.run();
					
					Scanner console = new Scanner (System.in);
					
					String consoleInput0 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "Server: " + "What is 9+9? " );
						
					}
					
					String consoleInput1 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "Server: " + "What is 180/10? " );
						
					}
					
					
					String consoleInput2 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "Server: " + "What is 6*3? " );
						
					}
					
					String consoleInput3 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "Server: " + "What is 38-20? " );
						
					}
					
					
					String consoleInput4 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "Server: " + "What is 18+0? " );
						
					}
					
					String result = console.nextLine();
					
					
					for(clientThread client : clients){
						
						client.score();
					
						client.writer.println( "The MathChamp is " + client.nm );
						
					}
					
				 }
				 
				
				
			}.start();
			
			
			int a=1;
			
			
			while(true){
				
				clients.add (new clientThread (serverSocket.accept() ) );
				clients.peekLast().start();
				System.out.println("Player " + a + " Joined");
				a++;
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

}

class clientThread extends Thread {
	
	Socket client;
	Scanner reader;
	Scanner reader1;
	PrintWriter writer;
	int scr = 0;
	int temp = 0;
	String nm = " ";
	
	public clientThread(Socket client){
		
		this.client = client;
		
		try {
			this.reader = new Scanner( client.getInputStream() );
			this.reader1 = new Scanner( client.getInputStream() );
			this.writer = new PrintWriter (client.getOutputStream(), true);
			
			
			
		} catch (IOException e) {
			
			System.out.println("Client has left");
			
			Server.clients.remove(this);
			
			
		}
		
	}
	
	
	
	public void run(){
		
		int s=0;
		super.run();
		writer.println("Lets Play MathCham !! :D" + "\n" + "Please Enter Your Name : ");
		String a= reader.nextLine();
		while(true){
		String b= reader1.nextLine();
		if(b.equals("18")){
			System.out.println( a  + " Correct Answer ??" + "\n" + "Send next question" );
			writer.println( "Your answer is correct!" );
			
		    s= score();
		    
		    
		    if(temp>s){
				
				temp=temp;
			    nm = a; 
			}
			else
			{
				temp = s;
				nm = a;
			}
			
		}
		else{
			System.out.println( a + " Wrong Answer ??" + "\n" + "Press any key to send the next Question to your Opponent(s).." );
			writer.println("Wrong Answer...");
		}
		writer.println( "Your Total Score is: " + s );
		
		}
	
		
		
		
	}
	public int score()
	{
		scr=scr+1;
		return scr;
	}
	
	
}