/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author yovanotti
 */
public class CmpObject {
    
    public static void main(String[] args) {
        
        
        Datos d1 = new Datos(1, "Yova", 35);
        Datos d2 = new Datos(1, "Yova", 35);
        Datos d3 = new Datos(2, "Adri", 28);
        Datos d4 = new Datos(2, "Adri", 28);
        Datos d5 = new Datos(3, "Pirolo", 36);
        
        
        List<Datos> lista = new ArrayList<>();
        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);
        
        List<Datos> listaLimpia = new ArrayList<>();
        
  
        //Forma número 1 (Uso de Maps).
        Map<Integer, Datos> mapPersonas = new HashMap<Integer, Datos>(lista.size());
        
        //Aquí está la magia
        for(Datos d : lista) {
           mapPersonas.put(d.getId(), d);
        }
        
        //Agrego cada elemento del map a una nueva lista y muestro cada elemento.
        System.out.println("Lista sin repetidos:");
        for(Entry<Integer, Datos> p : mapPersonas.entrySet()) {
            listaLimpia.add(p.getValue());
            System.out.println(p.getValue().getId());
        }
           
        ///////////////////////////
        
        
        List<String> cadenas = new ArrayList<>();
        cadenas.add("Yova");
        cadenas.add("Yova");
        cadenas.add("Adri");
        cadenas.add("Adri");
        cadenas.add("Pirolo");
        
             //Eliminar los repetidos
        HashSet<String> hashSet = new HashSet<String>(cadenas);
        cadenas.clear();
        cadenas.addAll(hashSet);
        
        for (String items : cadenas) {
            System.out.println("Lista de cadenas Sin repetir : "+items); 
        }
        
    }
    
    
    
    
 }
    
