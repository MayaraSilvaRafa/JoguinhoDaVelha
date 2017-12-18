/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.may.jogoVelha;

import static br.com.ifpe.may.jogoVelha.JogoWebService.tabuleiro;

/**
 *
 * @author mayara rafaelle
 */
public class Tabuleiro {
    
    public void construirTabuleiro() {
        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";

        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";

        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";
    }

    public String imprimirTabuleiro() {
        String imprimirTab = "";
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {

                imprimirTab += tabuleiro[i][j] + " | ";
            }
            imprimirTab = imprimirTab + "<br>";

        }
        return imprimirTab;
    }
}
