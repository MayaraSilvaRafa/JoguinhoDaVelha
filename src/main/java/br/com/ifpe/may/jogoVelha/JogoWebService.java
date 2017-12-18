package br.com.ifpe.may.jogoVelha;

import javax.persistence.QueryHint;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mayara rafaelle
 */

public class JogoWebService {

    static String tabuleiro[][] = new String[3][3]; 
    static JogoWebService tab = new JogoWebService();
    static Tabuleiro ta = new Tabuleiro();
    static boolean iniciar = true;
    static Jogador jogador1 = new Jogador("X");
    static Jogador jogador2 = new Jogador("O");
    static int vez;
    Jogo jogo = new Jogo();
    Jogador j;

    public static String[][] getTabuleiro() {
        return tabuleiro;
    }

    public static void setTabuleiro(String[][] tabuleiro) {
        JogoWebService.tabuleiro = tabuleiro;
    }

    public String jogar(String posicao) {

        if (iniciar == true) {
            JogoWebService.this.inicializar();
            iniciar = false;
            return ta.imprimirTabuleiro();
        }

        if (jogo.verificarPosicao(posicao, tab) == false) {
            return ta.imprimirTabuleiro() + "<br>" + "Jogada Inválida.Escolha outra posição";
        } else {
            jogo.realizarJogada(mudarJogador(), posicao, tab);
        }
         if (jogo.verificarVencedor(j, tab)== true) {
            iniciar = true;
            return ta.imprimirTabuleiro()+ "<br>" + "Jogo Acabou";
        }
        return ta.imprimirTabuleiro();
    }

    public String mostrar() {
        j = mudarJogador();
        j = mudarJogador();
        if (jogo.verificarVencedor(j, tab) == true) {
            iniciar = true;
            return "Parabens jogador " + j.getSimbolo() + ", vc venceu!";
        }
        return ta.imprimirTabuleiro();
    }

    public String verificarStatus() {
        if (jogo.verificarVencedor(j, tab) == true) {
            return tab.mostrar();

        }
        return ta.imprimirTabuleiro();
    }

    public void inicializar() {
        JogoWebService tab = new JogoWebService();
        jogo = new Jogo();
        vez = 1;
        ta.construirTabuleiro();  
    }

    public Jogador mudarJogador() {
        Jogador jogador;
        if (vez == 1) {
            jogador = jogador1;
            vez++;
        } else {
            jogador = jogador2;
            vez = 1;
        }
        return jogador;
    }

}
