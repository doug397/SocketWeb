package br.com.xti.socket.servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	public Servidor() {
		// leitor de mensagem do cliente
		Scanner leitor;
		// servidor socket
		ServerSocket server;
		
		
		// ouve todas as mensagens dos clientes usando Thread para ter clientes simultaneos
		try {
			server = new ServerSocket(5000);
			while(true){
				Socket cliente=	server.accept();
				Thread tr = new Thread(new EscutaCliente(cliente));
				tr.start();	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		
		new Servidor();

	}

}
