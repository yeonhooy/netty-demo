package com.demo.netty.c1nio.伪异步io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {

	public static void main(String[] args) {
		int port = 8080;
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			socket = new Socket("localhost", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("QUERY TIME ORDER");
			System.out.println("Send order 2 server successd.");
			String resp = in.readLine();
			System.out.println("Now is:" + resp);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(out != null){
					out.close();
				}
				if(in != null){
					in.close();
				}
				if(socket != null){
					socket.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
