package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public Client() {
            
	}

	
	public static void main(String[] args) {
		
		
		try {
			Socket server = new Socket("localhost", 8000);
			
			final Scanner reader = new Scanner( server.getInputStream() );
			PrintWriter writer = new PrintWriter ( server.getOutputStream(), true);
			
			Scanner console = new Scanner(System.in);
			
			System.out.println(reader.nextLine() );
			
	        new Thread(){
				
				public void run(){
				
					super.run();
					while(true)
						System.out.println( reader.nextLine() );
				
					
				  }
					
		
				
			}.start();
			
			while(true){
			
			writer.println(console.nextLine() );
			
			
			
			
		  }
			
			
		} catch (UnknownHostException e) {
                    
			e.printStackTrace();
                        
		} catch (IOException e) {
                    
			e.printStackTrace();
		}
		
		
		
		
		

	}

}