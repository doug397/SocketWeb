package br.com.xti.socket.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


// Classe Ruunnable para implementar na Thread e ouvir multiplos clientes
public class EscutaCliente implements Runnable {

	Scanner leitor;
	
	public EscutaCliente(Socket socket) {
	
		try {
			// leitor de mensagem
			 leitor = new Scanner(socket.getInputStream());
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// lEr a mensagem e imprime na tela enquanto for diferente de nullo
		try {
			String texto;
			while((texto =leitor.nextLine()) != null) {
				System.out.println("Recebeu "+ texto);
			}
		}catch (Exception e) {
		
		}
	
		
	}

}
