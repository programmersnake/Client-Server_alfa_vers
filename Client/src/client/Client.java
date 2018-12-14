package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        try{
            Socket client = new Socket("localhost", 8000);
            System.out.println("Connected to Server");
            while(true){                                                
                Scanner scan = new Scanner(System.in);            
                String request = scan.nextLine();                
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                client.getOutputStream()));
                BufferedReader bufreader = new BufferedReader(
                        new InputStreamReader(
                                client.getInputStream()));
                String j = bufreader.readLine();
                writer.write(request);
                writer.newLine();
                writer.flush();         
                System.out.println(j);
            }   
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
        
    }
    
}
