package server;

import com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDayDV;
import java.io.IOException;
import java.io.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.math.*;

public class Server {

    public static void main(String[] args) throws IOException {        
           ServerSocket server = new ServerSocket(8000);
           System.out.println("Server started!");   
        Runnable runnable = new Runnable() {   
            int i=0;             
            public void run() {
                try {                                                      
                        i++;
                        Socket socket = server.accept();
                        System.out.println("Client connected!");

                        BufferedWriter writer = new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));                        
                        System.out.println("\u001B[34m"+"Client send: '"+reader.readLine()+"'.");
                        int h = reader.read();
                        int f = h*h;
                            writer.write("Pow [2] ="+f);
                            writer.newLine();
                            writer.flush();                                                                         

                        writer.close();                        
                        if(socket.isConnected()==true)
                            System.out.println();
                        else{
                            socket.close();                        
                            System.out.println("Client disconnected! ");
                        }                                                                                   
                } catch (IOException ex) {
                    ex.getStackTrace();
                }             
            }
        };      
        while(true){ 
            runnable.run();
            if(false){
                server.close();
                System.out.println("Server finished!");
            }
        }
        
        
    }
    
    static String getDate(){
        Date date = new Date();
        String d = date.toString();
        return d;
    }
}
