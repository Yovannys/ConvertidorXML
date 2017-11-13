/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import com.convertidorxml.invocaciones.ClienteArticulos;


/**
 *
 * @author yovanotti
 */
public class Articulos {
    
    public static String invocar (String usuario, String clave, String usuarioSOAP, String codS,
                                  String nombreCarrito, int formatoXML){ 
     
        String retval = "";
        try {
           retval = ClienteArticulos.invocar(usuario, clave, usuarioSOAP, codS, nombreCarrito, formatoXML);
      
        } catch (Exception ex) {
           return ex.getMessage();
        }
        
        return retval;
    }
    
}
