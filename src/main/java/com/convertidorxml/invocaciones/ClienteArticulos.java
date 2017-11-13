/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.invocaciones;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.tempuri.IPArticulos;
import org.tempuri.IPArticulosservice;

/**
 *
 * @author yovanotti
 */
public class ClienteArticulos {
    
     public static String invocar (String usuario, String clave, String usuarioSOAP, String codS, String nombreCarrito, int formatoXML) throws MalformedURLException{
     
         URL url = new URL("http://www.unicom.com.uy/WServices/Articulos/P_Articulos.dll/wsdl/IP_Articulos");
         IPArticulosservice services = new IPArticulosservice(url,new QName("http://tempuri.org/", "IP_Articulosservice"));
         IPArticulos port = services.getIPArticulosPort();
         return port.datosArticulo(usuario, clave, usuarioSOAP, codS, nombreCarrito, formatoXML);
     }
    
}
