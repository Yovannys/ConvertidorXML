/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.invocaciones;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.tempuri.IPArticulos2;
import org.tempuri.IPArticulos2Service;

/**
 *
 * @author yovanotti
 */
public class ClienteArticulos2 {
    
     public static String invocar 
    (String usuario, String clave, String usuarioSOAP, String nombreCarrito,String filtroProducto, 
     String filtroEcGarantia, String codGrupo, String nuevos, String enLiquidacion, 
     int soloModificadosDesde, int codMarca, int campos, int ordenado, int formatoXML) throws MalformedURLException{
        
         URL url = new URL("http://www.unicom.com.uy/WServices/Articulos2/P_Articulos2.dll/wsdl/IP_Articulos2");
    
         IPArticulos2Service services = new IPArticulos2Service(url,new QName("http://tempuri.org/", "IP_Articulos2service"));
         IPArticulos2 port = services.getIPArticulos2Port();
         
         return port.
         articulosV2(usuario, clave, usuarioSOAP, nombreCarrito, filtroProducto, filtroEcGarantia, 
                 codGrupo, nuevos, enLiquidacion, soloModificadosDesde, codMarca, campos, ordenado, formatoXML);
           
   
    }
    
}
