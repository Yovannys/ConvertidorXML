/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import com.convertidorxml.invocaciones.ClienteGruposArticulos;



/**
 *
 * @author yovanotti
 */
public class GrupoArticulos {
    
   public static String invocar (String usuario, String clave, String usuarioSOAP, String grupoPadre, int formatoXML){ 

        String retval = "";
        try {
          retval =  ClienteGruposArticulos.invocar(usuario, clave, usuarioSOAP, grupoPadre, formatoXML);
        } catch (Exception ex) {
           return ex.getMessage();
        }
        
        return retval;
    }
   
 
   
}
