package br.com.ifpe.may.jogoVelha;

public class Jogo {

    // jogadas do jogo//
  

    public void realizarJogada(Jogador jogador, String posicao, JogoWebService tabuleiro) {

        for (int i = 0; i < tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.tabuleiro.length; j++) {
                if (posicao.equals(tabuleiro.tabuleiro[i][j])) {
                    tabuleiro.tabuleiro[i][j] = jogador.getSimbolo();
                }
            }
        }
    }

    public boolean verificarPosicao(String posicao, JogoWebService tabuleiro) {
        for (int i = 0; i < tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.tabuleiro.length; j++) {
                if (posicao.equals(tabuleiro.tabuleiro[i][j])) {
                    if (!tabuleiro.tabuleiro[i][j].equals("X")
                            && !tabuleiro.tabuleiro[i][j].equals("O")) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean verificarVencedor(Jogador jogador, JogoWebService tabuleiro) {
        // horizontais//
        if (tabuleiro.tabuleiro[0][0] == tabuleiro.tabuleiro[0][1] && tabuleiro.tabuleiro[0][1] == tabuleiro.tabuleiro[0][2]) {
            return true;
        } else if (tabuleiro.tabuleiro[1][0] == tabuleiro.tabuleiro[1][1] && tabuleiro.tabuleiro[1][1] == tabuleiro.tabuleiro[1][2]) {
            return true;
        } else if (tabuleiro.tabuleiro[2][0] == tabuleiro.tabuleiro[2][1] && tabuleiro.tabuleiro[2][1] == tabuleiro.tabuleiro[2][2]) {
            return true;
            //verticais//
        } else if (tabuleiro.tabuleiro[0][0] == tabuleiro.tabuleiro[1][0] && tabuleiro.tabuleiro[1][0] == tabuleiro.tabuleiro[2][0]) {
            return true;

        } else if (tabuleiro.tabuleiro[0][1] == tabuleiro.tabuleiro[1][1] && tabuleiro.tabuleiro[1][1] == tabuleiro.tabuleiro[2][1]) {
            return true;

        } else if (tabuleiro.tabuleiro[0][2] == tabuleiro.tabuleiro[1][2] && tabuleiro.tabuleiro[1][2] == tabuleiro.tabuleiro[2][2]) {

            return true;
            // diagonais//
        } else if (tabuleiro.tabuleiro[0][0] == tabuleiro.tabuleiro[1][1] && tabuleiro.tabuleiro[1][1] == tabuleiro.tabuleiro[2][2]) {

            return true;
        } else if (tabuleiro.tabuleiro[0][2] == tabuleiro.tabuleiro[1][1] && tabuleiro.tabuleiro[1][1] == tabuleiro.tabuleiro[2][0]) {

            return true;
        }

        return false;
    }

   
    

}
