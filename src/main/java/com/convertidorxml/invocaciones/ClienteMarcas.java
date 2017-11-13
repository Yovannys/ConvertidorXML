/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.invocaciones;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.tempuri.IPMarcas;
import org.tempuri.IPMarcasservice;

/**
 *
 * @author yovanotti
 */
public class ClienteMarcas {
   
    public static String invocar (String usuario, String clave, String usuarioSOAP, int codMarca, int campos, int formatoXML) throws MalformedURLException{
    
          URL url = new URL("http://www.unicom.com.uy/WServices/Marcas/P_Marcas.dll/wsdl/IP_Marcas");
          IPMarcasservice services = new IPMarcasservice(url, new QName("http://tempuri.org/", "IP_Marcasservice"));
          IPMarcas port = services.getIPMarcasPort();
		  
          return  port.marcas(usuario, clave, usuarioSOAP, codMarca, campos, formatoXML);
   
    }
         
    
}
