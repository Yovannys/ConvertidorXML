/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import com.convertidorxml.util.Articulo;
import com.convertidorxml.util.Utils;
import com.convertidorxml.util.WrapperArticulos;
import java.io.IOException;
import java.util.List;
import org.jdom2.JDOMException;

/**
 *
 * @author yovanotti
 */
public class Test {
    
    public static void main(String[] args) throws JDOMException, IOException, Exception {
        
        Conformar c = new Conformar();
        
        String usuario = "PLANETA IP";
        String clave = "planeta321789";
        String usuarioSOAP = "FDR76$X";
        String grupoPadre = "";
        int codMarca = -1;
        int campos = 1;
        int formatoXML = 2;
        
        String nombreCarrito = "";
        String filtroProducto = "";
        String filtroEcGarantia = "";

        String nuevos = "";
        String enLiquidacion = "";
        int soloModificadosDesde = 0;
        int ordenado = 0;
       
        c.setUsuario(usuario);
        c.setClave(clave);
        c.setUsuarioSOAP(usuarioSOAP);
        c.setGrupoPadre(grupoPadre);
        c.setCodMarca(codMarca);
        c.setCampos(campos);
        c.setFormatoXML(formatoXML);
        c.setNombreCarrito(nombreCarrito);
        c.setFiltroProducto(filtroProducto);
        c.setFiltroEcGarantia(filtroEcGarantia);
        c.setNuevos(nuevos);
        c.setEnLiquidacion(enLiquidacion);
        c.setSoloModificadosDesde(soloModificadosDesde);
        c.setOrdenado(ordenado);
        
        
       // c.listadoCodMarcas();
      //  c.listadoCodGrupos();
       
        // True: Filtra por grupos, False: Filtra por marcas.
        
       // c.listaArticulosFiltradosGrupos(false);
       
       c.conformarXMLs(true,"E:\\Respuestas\\");
        
        List<Articulo> retval = c.getListaArticulos();
        System.out.println("Size : " + retval.size());
        
                  System.out.println("*****************************************************************");
                  System.out.println("Mostrando los articulos :");
                
                  for (Articulo items : retval) {
                
                      System.out.println(" Codigo : "+items.getCods());
                      System.out.println(" Costo : "+items.getCosto());
                      System.out.println(" Desc : "+items.getDescripcion());
                      System.out.println(" En Liquidacion : "+items.getEnLiquidacion());
                      System.out.println(" Grupo : "+items.getGrupo());
                      System.out.println(" LinkDriver : "+items.getLinkDriver());
                      System.out.println(" LinkEspecificaciones : "+items.getLinkEspecificaciones());
                      System.out.println(" Marca : "+items.getMarca());
                      System.out.println(" Nuevo : "+items.getNuevo());
                      System.out.println(" Producto : "+items.getProducto());
                      System.out.println(" Subgrupo : "+items.getSubgrupo());
                      //System.out.println(" Foto : "+Utils.ByteTobase64(items.getFoto()));
                  }
        
    }
    
}
