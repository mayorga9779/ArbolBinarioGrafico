/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.principal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.umg.arbolbinario.ArbolBinario;
import org.umg.gui.Grafo;

/**
 *
 * @author Edgar Mayorga
 */
public class Main {
    public static void main(String[] args){
        System.out.println("DATOS DE ESTUDIANTE");
        try{
            System.out.println("==================================================");
            System.out.println("5190-05-407, MYNOR ADÁN LÓPEZ IZAGUIRRE, SECCION A");
            System.out.println("" + InetAddress.getLocalHost());
            System.out.println("==================================================");
            System.out.println();
        }catch(UnknownHostException ex){
            //Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println();
        
        Grafo grafo = new Grafo();
        grafo.setVisible(true);
        
        System.out.println("CARGA DE REGISTROS");
        System.out.println("****************************************************");
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertarNodo(25, "Electrónica Analógica", 3);
        arbol.insertarNodo(22, "Métodos Numéricos", 3);
        arbol.insertarNodo(23, "Programación III", 4);
        arbol.insertarNodo(24, "Emprendedores de Negocios", 2);
        arbol.insertarNodo(28, "Base de Datos I", 3);
        arbol.insertarNodo(26, "Estadística II", 3);
        arbol.insertarNodo(27, "Investigación de Operaciones", 2);
        arbol.insertarNodo(29, "Lenguajes Formáles y Autómatas", 4);
        arbol.insertarNodo(16, "Cálculo I", 3);
        System.out.println();
        System.out.println("****************************************************");
        System.out.println();
        System.out.println();
        
        System.out.println("****************************************************");
        if(!arbol.estaVacio()){
            System.out.println("RECORRIDO PREORDEN");
            arbol.preOrden(arbol.getRaiz());
        }else{
            System.out.println("El arbol esta vacio");
        }
        System.out.println("****************************************************");
        System.out.println();
        System.out.println();
        
        
        /*System.out.println("****************************************************");
        System.out.println("ELIMINACION DE NODO CODIGO 16");
        if(!arbol.estaVacio()){
            arbol.eliminar(16);
            arbol.inOrden(arbol.getRaiz());
        }
        System.out.println("****************************************************");
        System.out.println();
        System.out.println();*/
        
        
        System.out.println("****************************************************");
        System.out.println("RECORRIDO INORDEN");
        if(!arbol.estaVacio()){
            arbol.inOrden(arbol.getRaiz());
        }else{
            System.out.println("El arbol esta vacio");
        }
        System.out.println("****************************************************");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //arbol.imprimirArray();
        
        //Grafo grafo = new Grafo(arbol.totalElementos(), arbol.listaElementos());
        //grafo.setVisible(true);
        
        /*if(!arbol.estaVacio()){
            System.out.println("RECORRIDO INORDEN");
            arbol.inOrden(arbol.raiz);
        }else{
            System.out.println("El arbol esta vacio");
        }
        
        if(!arbol.estaVacio()){
            System.out.println("RECORRIDO PREORDEN");
            arbol.preOrden(arbol.raiz);
        }else{
            System.out.println("El arbol esta vacio");
        }
        
        if(!arbol.estaVacio()){
            System.out.println("RECORRIDO POSTORDEN");
            arbol.postOrden(arbol.raiz);
        }else{
            System.out.println("El arbol esta vacio");
        }
        
        if(!arbol.estaVacio()){
            System.out.println("ELIMINACION DE UN NODO");
            if(arbol.buscarNodo(25) == null){
                System.out.println("Nodo no encontrado");
            }else{
                System.out.println("El dato fue encontrado:");
                System.out.println(arbol.buscarNodo(27));
            }
        }
        
        if(!arbol.estaVacio()){
            System.out.println("ELIMINACION DE UN NODO");
            arbol.eliminar(16);
            arbol.inOrden(arbol.raiz);
        }*/
        
    }
}
