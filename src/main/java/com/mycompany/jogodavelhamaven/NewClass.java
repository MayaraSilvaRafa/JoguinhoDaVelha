/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogodavelhamaven;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mayara rafaelle
 */
@Path("newClass")
public class NewClass {
    
    @GET
    @Path ("somar")
    public String somar(@QueryParam("numero1") int num1,
                         @QueryParam("numero2")int num2){
        
        int x = num1+num2;
        return new Integer(x).toString();
    }
    
}
