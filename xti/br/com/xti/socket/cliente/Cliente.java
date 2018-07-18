package br.com.xti.socket.cliente;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cliente extends JFrame {
	
	private JTextField textoParaEnviar;
	private Socket socket;
	private PrintWriter escritor;
	// nome do Usuario que vai estar na tela
	private String nome;
	
	public Cliente(String nome) {
		super(nome);

		this.nome= nome;
		// Configura a interface Grafica
		Font fonte = new Font("Serif",Font.PLAIN,26);
		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
		// Configura o botao de envio de mensagem
		botao.addActionListener(new EnviarListener());
					
		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER,textoParaEnviar);
		envio.add(BorderLayout.EAST,botao);
		getContentPane().add(BorderLayout.SOUTH, envio);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,90);
		setVisible(true);
	
		// Configurando Rede do Socket
		configuraRede();

	}
	
	// classe de evento de click do botao enviar e enviar a mensagem pro servidor
	private class EnviarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	   // so faz escrever a mensagem 
			escritor.println(nome+" : "+textoParaEnviar.getText());
			escritor.flush();
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();
			
		}
		
	}
	
		// Configura a rede 
	
	private void configuraRede() {
		try {
	        socket = new Socket("127.0.0.1",5000);
	        escritor = new PrintWriter(socket.getOutputStream());
		}catch (Exception e) {
			System.out.println("Erro ao configurar Redes");
		}

	}
	

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		new Cliente("Douglas");
		new Cliente("Larissa");
	}

}
