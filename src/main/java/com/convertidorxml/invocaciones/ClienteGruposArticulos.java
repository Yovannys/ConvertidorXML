/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.invocaciones;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.tempuri.IPGruposArticulos;
import org.tempuri.IPGruposArticulosservice;

/**
 *
 * @author yovanotti
 */
public class ClienteGruposArticulos {
    
     public static String invocar (String usuario, String clave, String usuarioSOAP, String grupoPadre, int formatoXML) throws MalformedURLException{
    
         URL url = new URL("http://www.unicom.com.uy/WServices/Grupos_Articulos/P_Grupos_Articulos.dll/wsdl/IP_Grupos_Articulos");
         
         IPGruposArticulosservice services = new IPGruposArticulosservice(url,new QName("http://tempuri.org/", "IP_Grupos_Articulosservice"));
         IPGruposArticulos port = services.getIPGruposArticulosPort();
         return port.grupos(usuario, clave, usuarioSOAP, grupoPadre, formatoXML);
   
    }
    
}
