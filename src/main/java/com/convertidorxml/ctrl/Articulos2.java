/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import com.convertidorxml.invocaciones.ClienteArticulos2;



/**
 *
 * @author yovanotti
 */
public class Articulos2 {
    
    public static String invocar (String usuario, String clave, String usuarioSOAP, String nombreCarrito,String filtroProducto, 
     String filtroEcGarantia, String codGrupo, String nuevos, String enLiquidacion, 
     int soloModificadosDesde, int codMarca, int campos, int ordenado, int formatoXML){ 
        
        
//        System.out.println("Usuario : " + usuario );
//        System.out.println("clave : " + clave );
//        System.out.println("usuarioSOAP : " + usuarioSOAP );
//        System.out.println("nombreCarrito : " + nombreCarrito );
//        System.out.println("filtroProducto : " + filtroProducto );
//        System.out.println("filtroEcGarantia : " + filtroEcGarantia );
//        System.out.println("codGrupo : " + codGrupo );
//        System.out.println("nuevos : " + nuevos );
//        System.out.println("enLiquidacion : " + enLiquidacion );
//        System.out.println("soloModificadosDesde : " + soloModificadosDesde );
//        System.out.println("codMarca : " + codMarca );
//        System.out.println("campos : " + campos );
//        System.out.println("ordenado : " + ordenado );
//        System.out.println("formatoXML : " + formatoXML );
//        
         
        

        String retval = "";
        try {
           retval = ClienteArticulos2
                   .invocar(usuario, clave, usuarioSOAP, nombreCarrito, filtroProducto, 
                           filtroEcGarantia, codGrupo, nuevos, enLiquidacion, soloModificadosDesde, 
                           codMarca, campos, ordenado, formatoXML);
           
                   
           
        } catch (Exception ex) {
           return ex.getMessage();
        }
        
        return retval;
    }
    
}
