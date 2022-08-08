/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.arbolbinario;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.umg.nodoarbol.ArbolExpresionGrafico;
import org.umg.nodoarbol.Nodo;

/**
 *
 * @author Edgar Mayorga
 */
public class ArbolBinario {
    private Nodo raiz;
    private int num_nodos;
    private int alt;
    ArrayList<Object> listaCodigos = new ArrayList<Object>();
    
    public ArbolBinario(){
        raiz = null;
    }
    
    public void insertarNodo(int pCodigo, String pNombre, int pCreditos){
        Nodo nuevo = new Nodo(pCodigo, pNombre, pCreditos);
        
        if(getRaiz() == null){
            setRaiz(nuevo);
            System.out.print(getRaiz().getCodigoCurso() + ", ");
        }else{
            Nodo auxiliar = getRaiz();
            Nodo padre;
            
            while(true){
                padre = auxiliar;
                
                if(pCodigo < auxiliar.getCodigoCurso()){
                    auxiliar = auxiliar.getNodoIzquierdo();
                    
                    if(auxiliar == null){
                        padre.setNodoIzquierdo(nuevo);
                        System.out.print(nuevo.getCodigoCurso() + ", ");
                        return;
                    }
                }else{
                    auxiliar = auxiliar.getNodoDerecho();
                    
                    if(auxiliar == null){
                        padre.setNodoDerecho(nuevo);
                        System.out.print(nuevo.getCodigoCurso() + ", ");
                        return;
                    }
                }
            }
        }
    }
    
    //Metodo para saber si el arbol esta vacio.
    public boolean estaVacio(){
        boolean retorna = false;
        
        if(getRaiz() == null){
            retorna = true;
        }
        
        return retorna;
    }
    
    //Metodo para recorrer el arbon InOrden
    public void inOrden(Nodo r){    //r es la raiz
        if(r != null){
            inOrden(r.getNodoIzquierdo());
            System.out.println(r.getCodigoCurso());
            System.out.println(r.getNombreCurso());
            System.out.println(r.getCreditos());
            System.out.println("________________________________________________");
            inOrden(r.getNodoDerecho());
        }
    }
    
    //Metodo para recorrer PreOrden
    public void preOrden(Nodo r){
        if(r != null){
            System.out.println("Codigo: " + r.getCodigoCurso());
            System.out.println("Curso: " + r.getNombreCurso());
            System.out.println("Creditos: " + r.getCreditos());
            System.out.println("________________________________________________");
            preOrden(r.getNodoIzquierdo());
            preOrden(r.getNodoDerecho());
        }
    }
    
    //Metodo para recorrer PostOrden
    public void postOrden(Nodo r){
        if(r != null){
            postOrden(r.getNodoIzquierdo());
            postOrden(r.getNodoDerecho());
            System.out.println(r.getCodigoCurso());
            System.out.println(r.getNombreCurso());
            System.out.println(r.getCreditos());
            System.out.println("________________________________________________");
        }
    }
    
    //Busqueda de un nodo
    public Nodo buscarNodo(int pCodigoCurso){
        Nodo auxiliar = getRaiz();
        
        while(auxiliar.getCodigoCurso() != pCodigoCurso){
            if(pCodigoCurso < auxiliar.getCodigoCurso()){
                auxiliar = auxiliar.getNodoIzquierdo();
            }else{
                auxiliar = auxiliar.getNodoDerecho();
            }
            
            if(auxiliar == null){
                return null;
            }
        }
        
        return auxiliar;
    }
    
    //Eliminar un nodo
    public boolean eliminar(int pCodigoCurso){
        Nodo auxiliar = getRaiz();
        Nodo padre = getRaiz();
        boolean esHijoIzq = true;
        
        while(auxiliar.getCodigoCurso() != pCodigoCurso){
            padre = auxiliar;
            
            if(pCodigoCurso < auxiliar.getCodigoCurso()){
                esHijoIzq = true;
                auxiliar = auxiliar.getNodoIzquierdo();
            }else{
                esHijoIzq = false;
                auxiliar = auxiliar.getNodoDerecho();
            }
            
            if(auxiliar == null){
                return false;
            }
        }//fin del while
        
        if(auxiliar.getNodoIzquierdo() == null && auxiliar.getNodoDerecho() == null){
            if(auxiliar == getRaiz()){
                setRaiz(null);
            }else if(esHijoIzq){
                padre.setNodoIzquierdo(null);
            }else{
                padre.setNodoDerecho(null);
            }
        }else if(auxiliar.getNodoDerecho() == null){
            if(auxiliar == getRaiz()){
                setRaiz(auxiliar.getNodoIzquierdo());
            }else if(esHijoIzq){
                padre.setNodoIzquierdo(auxiliar.getNodoIzquierdo());
            }else{
                padre.setNodoDerecho(auxiliar.getNodoIzquierdo());
            }
        }else if(auxiliar.getNodoIzquierdo() == null){
            if(auxiliar == getRaiz()){
                setRaiz(auxiliar.getNodoDerecho());
            }else if(esHijoIzq){
                padre.setNodoIzquierdo(auxiliar.getNodoDerecho());
            }else{
                padre.setNodoDerecho(auxiliar.getNodoIzquierdo());
            }
        }else{
            Nodo reemplazo = obtenerNodoReemplazo(auxiliar);
            
            if(auxiliar == getRaiz()){
                setRaiz(reemplazo);
            }else if(esHijoIzq){
                padre.setNodoIzquierdo(reemplazo);
            }else{
                padre.setNodoDerecho(reemplazo);
            }
            
            reemplazo.setNodoIzquierdo(auxiliar.getNodoIzquierdo());
        }
        
        return true;
    }
    
    //Metodo encargado de devolvernos el nodo reemplazo
    public Nodo obtenerNodoReemplazo(Nodo nodoReemplazo){
        Nodo reemplazarPadre = nodoReemplazo;
        Nodo reemplazo = nodoReemplazo;
        Nodo auxiliar = nodoReemplazo;
        
        while(auxiliar != null){
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.getNodoIzquierdo();
        }
        
        if(reemplazo != nodoReemplazo.getNodoDerecho()){
            reemplazarPadre.setNodoIzquierdo(reemplazo.getNodoDerecho());
            reemplazo.setNodoDerecho(nodoReemplazo.getNodoDerecho());
        }
        
        System.out.println("El nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }
    
    public boolean agregar(int codigo, String curso, int creditos) {
        Nodo nuevo = new Nodo(codigo, curso, creditos, null, null);
        insertar(nuevo, getRaiz());
        listaCodigos.add(codigo);
        
        return true;
    }
    
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.getRaiz() == null) {
            setRaiz(nuevo);
        } else {
            if (nuevo.getCodigoCurso() <= pivote.getCodigoCurso()) {
                if (pivote.getNodoIzquierdo() == null) {
                    pivote.setNodoIzquierdo(nuevo);
                } else {
                    insertar(nuevo, pivote.getNodoIzquierdo());
                }
            } else {
                if (pivote.getNodoDerecho() == null) {
                    pivote.setNodoDerecho(nuevo);
                } else {
                    insertar(nuevo, pivote.getNodoDerecho());
                }
            }
        }
    }
    
    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public ArrayList preOrden() {
        ArrayList<Nodo> rec = new ArrayList<Nodo>();
        preorden(getRaiz(), rec);
        
        return rec;
    }
    
    public void preorden(Nodo aux, ArrayList<Nodo> recorrido) {
        if (aux != null) {
            Nodo nodo = new Nodo(aux.getCodigoCurso(), aux.getNombreCurso(), aux.getCreditos());
            recorrido.add(nodo);
            preorden(aux.getNodoIzquierdo(), recorrido);
            preorden(aux.getNodoDerecho(), recorrido);
        }
    }
    
    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public ArrayList inOrden() {
        ArrayList<Nodo> rec = new ArrayList<Nodo>();
        inorden(getRaiz(), rec);
        return rec;
    }
    
    public void inorden(Nodo aux, ArrayList<Nodo> recorrido) {
        int codigo = 0;
        String curso = "";
        int creditos = 0;
        
        if (aux != null) {
            inorden(aux.getNodoIzquierdo(), recorrido);
            Nodo nodo = new Nodo(aux.getCodigoCurso(), aux.getNombreCurso(), aux.getCreditos());
            recorrido.add(nodo);
            inorden(aux.getNodoDerecho(), recorrido);
        }
    }
    
    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public ArrayList postOrden() {
        ArrayList<Nodo> rec = new ArrayList<Nodo>();
        postorden(getRaiz(), rec);
        return rec;
    }
    
    public void postorden(Nodo aux, ArrayList<Nodo> recorrido) {
        if (aux != null) {
            postorden(aux.getNodoIzquierdo(), recorrido);
            postorden(aux.getNodoDerecho(), recorrido);
            Nodo nodo = new Nodo(aux.getCodigoCurso(), aux.getNombreCurso(), aux.getCreditos());
            recorrido.add(nodo);
        }
    }
    
    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = getRaiz();
        
        while (aux != null) {
            if (dato == aux.getCodigoCurso()) {
                return true;
            } else if (dato > aux.getCodigoCurso()) {
                aux = aux.getNodoDerecho();
            } else {
                aux = aux.getNodoIzquierdo();
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getNodoIzquierdo(), nivel + 1);
            setAlt(nivel);
            altura(aux.getNodoDerecho(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(getRaiz(), 1);
        return getAlt();
    }
    
    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }

    /**
     * @return the raiz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the num_nodos
     */
    public int getNum_nodos() {
        return num_nodos;
    }

    /**
     * @param num_nodos the num_nodos to set
     */
    public void setNum_nodos(int num_nodos) {
        this.num_nodos = num_nodos;
    }

    /**
     * @return the alt
     */
    public int getAlt() {
        return alt;
    }

    /**
     * @param alt the alt to set
     */
    public void setAlt(int alt) {
        this.alt = alt;
    }
}
