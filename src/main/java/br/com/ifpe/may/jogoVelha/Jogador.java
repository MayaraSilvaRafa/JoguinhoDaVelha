package br.com.ifpe.may.jogoVelha;

public class Jogador {
	// jogadas do jogador //

		String simbolo;
		String nome;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Jogador(String simbolo) {
			this.simbolo = simbolo;
		}

		public String getSimbolo() {
			return simbolo;
		}

		public void setSimbolo(String simbolo) {
			this.simbolo = simbolo;
		}
		
		Jogador(String Simbolo, String Nome){
			this.simbolo = Simbolo;
			this.nome = Nome;
		}
		

}
