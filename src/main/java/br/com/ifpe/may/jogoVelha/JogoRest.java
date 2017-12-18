/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.may.jogoVelha;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mayara rafaelle
 */
@Path("joguinho") //Nome da classe que vai ficar url.
public class JogoRest {

    static JogoWebService jogo = new JogoWebService();

    @GET
    @Path("tabuleiro")
    public String jogar(@QueryParam("posicao") String posicao) {
        return jogo.jogar(posicao);
    }

    @GET
    @Path("mostrarVencedor")
    public String mostrarVencedor() {
        return jogo.mostrar();
    }
    
  
}
