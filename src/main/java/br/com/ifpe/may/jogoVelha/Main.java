package br.com.ifpe.may.jogoVelha;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		System.out.println("*** Jogo da Velha ***");

		tab.construirTabuleiro();
		tab.imprimirTabuleiro();

		System.out.println("---------------------");
		System.out.println("Escreva seu nome, voce será X");
		String nome1 = teclado.next();
		Jogador jogador1 = new Jogador("X", nome1);
		System.out.println("Escreva seu nome, voce será O");
		String nome2 = teclado.next();
		Jogador jogador2 = new Jogador("O",nome2);

		Jogo jogo = new Jogo();

		for (int i = 0; i < 9; i++) {
			Jogador jogador;
			if(i % 2 == 0){
				jogador = jogador1;
                                
			}else{
				jogador = jogador2;
			}
			System.out.println("Qual posição voce deseja jogar," +
                                " "+ jogador.nome + "?");
			String posicao = teclado.next();

			if(jogo.verificarPosicao(posicao, tab) == false){
				System.out.println("Escolha uma nova posição");
				String novaPosicao = teclado.next();
				jogo.realizarJogada(jogador , novaPosicao, tab);
			}else{
				jogo.realizarJogada(jogador, posicao, tab);
			}
			if(jogo.verificarVencedor(jogador, tab)){
				break;
			}
			tab.imprimirTabuleiro();    


		}

		

	}

}
