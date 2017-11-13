/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import com.convertidorxml.util.Articulo;
import com.convertidorxml.util.WrapperArticulos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.sql.rowset.Predicate;
import org.apache.commons.collections.CollectionUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author yovanotti
 */
public class Conformar {
    
    private String usuario;
    private String clave ;
    private String usuarioSOAP ;
    private String grupoPadre;
    private int codMarca;
   
    private String nombreCarrito;
    private String filtroProducto;
    private String filtroEcGarantia;
    
    private String nuevos;
    private String enLiquidacion;
    private int soloModificadosDesde;
    private int ordenado;
    private int campos;
    private int formatoXML;
 
    private List<String> listadoCodMarcas;
    private List<String> listadoCodGrupos;
    private List<Articulo> listaArticulos;
   // private List<WrapperArticulos> listaArticulosGlobales;

    public Conformar() {
       // listaArticulosGlobales = new LinkedList<>();
        listadoCodMarcas = new LinkedList<>();
        listadoCodGrupos = new LinkedList<>();
        listaArticulos = new LinkedList<>();
    }
    
    public void conformarXMLs(boolean flag ,String savePath) throws JDOMException, IOException, Exception{
        
         System.out.println(savePath);
         System.out.println(flag);
         
      /*  Articulo art1 =  new Articulo();
         art1.setCods("cod1");
         art1.setCosto("costo1");
         art1.setDescripcion("desc1");
         art1.setGrupo("grupo1");
         art1.setLinkDriver("link1");
         art1.setLinkEspecificaciones("espec1");
         art1.setMarca("marca1");
         art1.setNuevo("nuevo1");
         art1.setProducto("prod1");
         art1.setSubgrupo("sub1");
         
         Articulo art2 =  new Articulo();
         art2.setCods("cod2");
         art2.setCosto("costo2");
         art2.setDescripcion("desc2");
         art2.setGrupo("grupo2");
         art2.setLinkDriver("link2");
         art2.setLinkEspecificaciones("espec2");
         art2.setMarca("marca2");
         art2.setNuevo("nuevo2");
         art2.setProducto("prod2");
         art2.setSubgrupo("sub2");
         
         listaArticulos.add(art1);
         listaArticulos.add(art2);
         
         
        //Juego de datos de prueba
           */
        
        conformarObjectXML(flag);
        crearXMLFisico(savePath);
     
    }
    
    public void crearXMLFisico(String savePath) throws Exception{
        
      
         if (listaArticulos==null || listaArticulos.isEmpty()){
              throw new Exception("No existen articulos disponibles en la lista global...");
         }else{
           /*  
             /////////////////////////////
             System.out.println("Estoy en el XML  limpiando antes: "+listaArticulos.size());
                //AQUI elimino los articulos repetidos.
              List<Articulo> listaLimpia = eliminarRepetidos(listaArticulos);
              
              //Lleno la lista global con los articulos sin repetir.
              listaArticulos.clear();
              listaArticulos.addAll(listaLimpia);
    
              // Procesando articulos con el ws
                System.out.println(" Estoy en el XML  despues del limpiado : "+listaArticulos.size());
             /////////////////////////////
            */ 
                // Creando el XML Raiz
                            Element productos = new Element("Productos");
                            Document doc = new Document(productos);
                     //   
               for (Articulo items : listaArticulos) {
                    
                    //Elementos
                       Element producto = new Element("Producto");

                       producto.addContent(new Element("codigo").setText(items.getCods()));
                       producto.addContent(new Element("nombre").setText(items.getProducto()));
                       producto.addContent(new Element("detalle").setText(items.getDescripcion()));
                      // producto.addContent(new Element("imagen").setText(Utils.ByteTobase64(items.getFoto())));
                       producto.addContent(new Element("costo").setText(items.getCosto()));
                       producto.addContent(new Element("categoria").setText(items.getGrupo()));
                       producto.addContent(new Element("subcategoria").setText(items.getSubgrupo()));
                       producto.addContent(new Element("marca").setText(items.getMarca()));
                       producto.addContent(new Element("enLiquidacion").setText(items.getEnLiquidacion()));
                       producto.addContent(new Element("linkEspecificaciones").setText(items.getLinkEspecificaciones()));
                       producto.addContent(new Element("nuevo").setText(items.getNuevo()));
                       producto.addContent(new Element("linkDriver").setText(items.getLinkDriver()));
                       producto.addContent(new Element("disponibilidad").setText(items.getDisponibilidad()));
                       producto.addContent(new Element("garantia").setText(items.getGarantia()));

                       doc.getRootElement().addContent(producto);
                
               }
               
                        XMLOutputter xmlOutput = new XMLOutputter();

                        // display nice nice
                        xmlOutput.setFormat(Format.getPrettyFormat());
                       
                       // xmlOutput.output(doc, new FileWriter(savePath+"ArchivoProductos.xml"));
                        
                        // Inicio con encoding
                        
                        FileOutputStream fileOutput = new FileOutputStream(new File(savePath+"ArchivoProductos.xml"));
                        xmlOutput.output(doc, fileOutput);
                        
                        // End Con encoding
          }
         
         
    }
            
    private void conformarObjectXML(boolean flag) throws JDOMException, IOException, Exception{
        
          listaArticulosFiltradosGrupos(flag);
                
         if (listaArticulos==null || listaArticulos.isEmpty()){
               throw new Exception("No existen articulos disponibles en la lista global...");
            
          }else{
          
              //AQUI elimino los articulos repetidos.
              List<Articulo> listaLimpia = eliminarRepetidos(listaArticulos);
              
              //Lleno la lista global con los articulos sin repetir.
              listaArticulos.clear();
              listaArticulos.addAll(listaLimpia);
    
                 for (Articulo itemArtGlobales : listaArticulos) {
                     
                        String response = Articulos.invocar(usuario, clave, usuarioSOAP, itemArtGlobales.getCods(), 
                                                           nombreCarrito, formatoXML);
                      
                       response = response.trim().replaceFirst("^([\\W]+)<","<");
                        
                      if (         response != null 
                               && !response.isEmpty()  
                               && ( response.startsWith("<?xml version=\"1.0\" standalone=\"yes\"?>" ) || response.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" ) || response.startsWith("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" ))){
                          Articulo artTemp = procesarFinalResponse(response);

                          // Actualizando los elementos 
                          itemArtGlobales.setCods(artTemp.getCods());
                          itemArtGlobales.setCosto(artTemp.getCosto());
                          itemArtGlobales.setDescripcion(artTemp.getDescripcion());
                          itemArtGlobales.setEnLiquidacion(artTemp.getEnLiquidacion());
                        //  items.setFoto(artTemp.getFoto());
                          itemArtGlobales.setLinkDriver(artTemp.getLinkDriver());
                          itemArtGlobales.setLinkEspecificaciones(artTemp.getLinkEspecificaciones());
                          itemArtGlobales.setMarca(artTemp.getMarca());
                          itemArtGlobales.setNuevo(artTemp.getNuevo());
                          itemArtGlobales.setProducto(artTemp.getProducto());
                          itemArtGlobales.setDisponibilidad(artTemp.getDisponibilidad());
                          itemArtGlobales.setGarantia(artTemp.getGarantia());
                          
                          //Se mantienen
                         // items.setGrupo(artTemp.getGrupo());
                         // items.setSubgrupo(items.getSubgrupo());

                        //  listaArticulosTemp.add(items);

                      }
                        
                 
                 }
           }
       
    }
 
    private List<Articulo> eliminarRepetidos (List<Articulo> listaOriginal){
     
        List<Articulo> retval = new LinkedList<>();
       //Forma número 1 (Uso de Maps).
        Map<String, Articulo> mapArticulos = new HashMap<String, Articulo>(listaOriginal.size());
        //Aquí está la magia
        for(Articulo art : listaOriginal) {
           mapArticulos.put(art.getCods(), art);
        }
        
         //Agrego cada elemento del map a una nueva lista y muestro cada elemento.
       
        for(Map.Entry<String, Articulo> p : mapArticulos.entrySet()) {
            retval.add(p.getValue());
            
        }
       return retval;
        
    }
    
    private Articulo procesarFinalResponse(String response) throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(new StringReader(response.trim()));
        Element rootNode = document.getRootElement();
      
        Element rowdata = rootNode.getChild("ROWDATA");
         
        List<Element> lista = rowdata.getChildren();
        Articulo art =  new Articulo();
        
        for (Element items : lista) {
       
          art.setCods(items.getAttributeValue("CODS"));
          art.setCosto(items.getAttributeValue("Costo"));
          art.setDescripcion(items.getAttributeValue("DESCRIPCION"));
          art.setEnLiquidacion(items.getAttributeValue("ENLIQUIDACION"));
         // art.setFoto(Utils.base64ToByte(items.getAttributeValue("FOTO_GRANDE")));
         
          art.setLinkDriver(items.getAttributeValue("LINK_DRIVER"));
          art.setLinkEspecificaciones(items.getAttributeValue("LINK_ESPECIFICACIONES"));
          
          art.setMarca(items.getAttributeValue("Marca"));
          art.setNuevo(items.getAttributeValue("NUEVO"));
          art.setProducto(items.getAttributeValue("PRODUCTO"));
          art.setDisponibilidad(items.getAttributeValue("Disponibilidad"));
          art.setGarantia(items.getAttributeValue("Garantia"));
             
        }
        
        return art;
    }
    
    public void listaArticulosFiltradosGrupos (boolean flag ) throws JDOMException, IOException{
     
       if (flag){
           listadoCodGrupos();
           if (listadoCodGrupos==null || listadoCodGrupos.isEmpty()){
               System.out.println("Error invocando los grupos");
           }
            else{
               
            
                     for (String itemsGrupos : listadoCodGrupos) {
                   
                           String response = Articulos2.
                                      invocar(usuario, clave, usuarioSOAP, nombreCarrito, 
                                      filtroProducto, filtroEcGarantia, itemsGrupos.trim(), nuevos,
                                      enLiquidacion, soloModificadosDesde, codMarca, campos, 
                                      ordenado, formatoXML);

                           if (response != null 
                               && !response.isEmpty()  
                               && ( response.startsWith("<?xml version=\"1.0\" standalone=\"yes\"?>" ) || response.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" ) || response.startsWith("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" ))){

                             List<Articulo> listaArticulosTemp= procesarResponse(response);
                              
                           
                          
                             adicionarArticulosListaGlobal(listaArticulosTemp);
                          
                          }else{
                               System.out.println("Respuesta WS Articulos: Encabezado no valido");
                           }
                    }
                   
              }
       }else{
            listadoCodMarcas();
            if (listadoCodMarcas==null || listadoCodMarcas.isEmpty()){
               System.out.println("Error invocando las marcas");
            }else{
                   for (String itemsMarcas : listadoCodMarcas) {
                        String response = Articulos2.
                                      invocar(usuario, clave, usuarioSOAP, nombreCarrito, 
                                      filtroProducto, filtroEcGarantia, "", nuevos,
                                      enLiquidacion, soloModificadosDesde, Integer.parseInt(itemsMarcas.trim()), campos, 
                                      ordenado, formatoXML);
                        if (response != null 
                               && !response.isEmpty()  
                               && ( response.startsWith("<?xml version=\"1.0\" standalone=\"yes\"?>" ) || response.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" ) || response.startsWith("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" ))){
                            
                            List<Articulo> listaArticulosTemp= procesarResponse(response);
                                                      
                             adicionarArticulosListaGlobal(listaArticulosTemp);
                             
                         }
                   }
             }
        }
      
    }
      
    private void adicionarArticulosListaGlobal (List<Articulo> listaArticulosTemp){
        
        for (Articulo items : listaArticulosTemp) {
         
           listaArticulos.add(items);
        }
           
    }
    
    private List<Articulo> procesarResponse (String response) throws JDOMException, IOException     {
        
        List<Articulo> retval = new ArrayList<>();
        
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(new StringReader(response.trim()));
        Element rootNode = document.getRootElement();
      
        Element rowdata = rootNode.getChild("ROWDATA");
         
        List<Element> lista = rowdata.getChildren();
              
        for (Element items : lista) {
          
          Articulo art =  new Articulo();
         
          art.setCods(items.getAttributeValue("CODS").trim());
          art.setCosto(items.getAttributeValue("Costo").trim());
          art.setDescripcion("");
          art.setEnLiquidacion("");
        //  art.setFoto(Utils.base64ToByte(items.getAttributeValue("FOTO_CHICA")));
          art.setGrupo(items.getAttributeValue("CODGRUPO").trim());
          art.setLinkDriver("");
          art.setLinkEspecificaciones("");
          art.setMarca(items.getAttributeValue("Marca").trim());
          art.setNuevo("");
          art.setProducto(items.getAttributeValue("PRODUCTO").trim());
          art.setSubgrupo(items.getAttributeValue("Grupo"));
          art.setDisponibilidad(items.getAttributeValue("Disponibilidad").trim());
           
          //  System.out.println("Garantia: " + items.getAttributeValue("Garantia").trim());
          art.setGarantia(items.getAttributeValue("Garantia").trim());
          
          retval.add(art);
              
        }
        
      return retval;
    
    }
   
    public void listadoCodMarcas () throws JDOMException, IOException{
        
        String responseMarcas = Marcas.invocar(usuario, clave, usuarioSOAP, codMarca, campos, formatoXML);
              
        listadoCodMarcas = obtenerCodigosMarcas(responseMarcas);
          //Eliminar los repetidos
        HashSet<String> hashSet = new HashSet<String>(listadoCodMarcas);
        listadoCodMarcas.clear();
        listadoCodMarcas.addAll(hashSet);
    }
    
    public void listadoCodGrupos () throws JDOMException, IOException{
        
        String responseGruposArticulos = GrupoArticulos.invocar(usuario, clave, usuarioSOAP, grupoPadre, formatoXML);
        
        listadoCodGrupos = obtenerCodigosGrupos(responseGruposArticulos);
        
        //Eliminar los repetidos
        HashSet<String> hashSet = new HashSet<String>(listadoCodGrupos);
        listadoCodGrupos.clear();
        listadoCodGrupos.addAll(hashSet);
      
    }
       
    private List<String> obtenerCodigosMarcas (String xml) throws JDOMException, IOException{
        List<String> retval = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(new StringReader(xml.trim()));
        Element rootNode = document.getRootElement();
      
        Element rowdata = rootNode.getChild("ROWDATA");
         
        List<Element> datos = rowdata.getChildren();
        
              // Filtrando
                          
     /*   CollectionUtils.filter(lista, new Predicate() {
        @Override
              public boolean evaluate(Object arg0) {
                      RCObtenerCfdEdoCtaBean comp = (RCObtenerCfdEdoCtaBean) arg0;
                      return (comp.getBase64Binary()!=null);
              }
        });*/
        
        for (Element items : datos) {
          if (!items.getAttributeValue("CODMARCA").isEmpty())  
            retval.add(items.getAttributeValue("CODMARCA"));
              
        }
        
        return retval;
    }
    
    private List<String> obtenerCodigosGrupos (String xml) throws JDOMException, IOException{
        List<String> retval = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(new StringReader(xml.trim()));
        Element rootNode = document.getRootElement();
      
        Element rowdata = rootNode.getChild("ROWDATA");
         
        List<Element> datos = rowdata.getChildren();
        
              // Filtrando
                          
     /*   CollectionUtils.filter(lista, new Predicate() {
        @Override
              public boolean evaluate(Object arg0) {
                      RCObtenerCfdEdoCtaBean comp = (RCObtenerCfdEdoCtaBean) arg0;
                      return (comp.getBase64Binary()!=null);
              }
        });*/
        
        for (Element items : datos) {
          if (!items.getAttributeValue("CODGRUPO").isEmpty())  
            retval.add(items.getAttributeValue("CODGRUPO"));
              
        }
        
        return retval;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuarioSOAP() {
        return usuarioSOAP;
    }

    public void setUsuarioSOAP(String usuarioSOAP) {
        this.usuarioSOAP = usuarioSOAP;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getFormatoXML() {
        return formatoXML;
    }

    public void setFormatoXML(int formatoXML) {
        this.formatoXML = formatoXML;
    }

    public String getGrupoPadre() {
        return grupoPadre;
    }

    public void setGrupoPadre(String grupoPadre) {
        this.grupoPadre = grupoPadre;
    }

    public List<String> getListadoCodMarcas() {
        return listadoCodMarcas;
    }

    public void setListadoCodMarcas(List<String> listadoCodMarcas) {
        this.listadoCodMarcas = listadoCodMarcas;
    }

    public List<String> getListadoCodGrupos() {
        return listadoCodGrupos;
    }

    public void setListadoCodGrupos(List<String> listadoCodGrupos) {
        this.listadoCodGrupos = listadoCodGrupos;
    }

    public String getNombreCarrito() {
        return nombreCarrito;
    }

    public void setNombreCarrito(String nombreCarrito) {
        this.nombreCarrito = nombreCarrito;
    }

    public String getFiltroProducto() {
        return filtroProducto;
    }

    public void setFiltroProducto(String filtroProducto) {
        this.filtroProducto = filtroProducto;
    }

    public String getFiltroEcGarantia() {
        return filtroEcGarantia;
    }

    public void setFiltroEcGarantia(String filtroEcGarantia) {
        this.filtroEcGarantia = filtroEcGarantia;
    }

    public String getNuevos() {
        return nuevos;
    }

    public void setNuevos(String nuevos) {
        this.nuevos = nuevos;
    }

    public String getEnLiquidacion() {
        return enLiquidacion;
    }

    public void setEnLiquidacion(String enLiquidacion) {
        this.enLiquidacion = enLiquidacion;
    }

    public int getSoloModificadosDesde() {
        return soloModificadosDesde;
    }

    public void setSoloModificadosDesde(int soloModificadosDesde) {
        this.soloModificadosDesde = soloModificadosDesde;
    }

    public int getOrdenado() {
        return ordenado;
    }

    public void setOrdenado(int ordenado) {
        this.ordenado = ordenado;
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

  /*  public List<WrapperArticulos> getListaArticulosGlobales() {
        return listaArticulosGlobales;
    }

    public void setListaArticulosGlobales(List<WrapperArticulos> listaArticulosGlobales) {
        this.listaArticulosGlobales = listaArticulosGlobales;
    }
   */ 
    
    
    
}
