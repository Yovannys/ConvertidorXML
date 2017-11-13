/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import com.convertidorxml.invocaciones.ClienteMarcas;

/**
 *
 * @author yovanotti
 */
public class Marcas {
    
    public static String invocar (String usuario, String clave, String usuarioSOAP , int codMarca, int campos, int formatoXML){ 

        String retval = "";
        try {
           retval = ClienteMarcas.invocar(usuario, clave, usuarioSOAP, codMarca, campos, formatoXML);
        } catch (Exception ex) {
           return ex.getMessage();
        }
        
        return retval;
    }
    
    
    
}
