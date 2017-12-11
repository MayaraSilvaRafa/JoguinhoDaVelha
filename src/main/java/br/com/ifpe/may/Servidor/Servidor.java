package br.com.ifpe.may.Servidor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {
	
	private ServerSocket server;
	private boolean inicializado;
	private boolean executando;
	
	private Thread thread;
	
	public Servidor(int porta) throws Exception{
		inicializado = false;
		executando = false;
		
		open(porta);
	}
	private void open(int porta) throws Exception {
		server = new ServerSocket(porta);
		inicializado = true;
	}
	
	private void close(){
		try{
			server.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		server = null;
		inicializado = false;
		executando = false;
		
		thread = null;
	}
	
	public void start() {
		if (!inicializado || executando) {
			return;
			
		}
		executando = true;
		thread = new Thread(this);
		thread.start();
		// start faz com o que se inicie a execucao do metodo run()//
			
		}
	public void stop() throws Exception{
		executando = false;
		thread.join();
		
	}
	
	
	
	public void run(){
		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Iniciando servidor");

		ServerSocket server = new ServerSocket(2525);
		
		System.out.println("Aguardando conexão");
		
		Socket socket = server.accept();
		
		System.out.println("Conexão estabelecida");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		while(true){
			String mensagem = in.readLine();
			
			System.out.println(
					"Mensagem recebida do cliente [" + 
			socket.getInetAddress().getHostName() +
			"] : " + mensagem);
			
			if ("FIM".equals(mensagem)) {
				break;
				
			}
			out.println(mensagem);
		}
		System.out.println("Encerrando conexão");
		in.close();
		out.close();
		socket.close();
		System.out.println("Encerrando servidor");
		server.close();
		
	}

}
