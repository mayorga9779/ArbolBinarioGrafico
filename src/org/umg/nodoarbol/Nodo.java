/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.nodoarbol;

/**
 *
 * @author Edgar Mayorga
 */
public class Nodo {
    private int codigoCurso;
    private String nombreCurso;
    private int creditos;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;
    
    public Nodo(int pCodigoCurso, String pNombreCurso, int pCreditos){
        this.codigoCurso = pCodigoCurso;
        this.nombreCurso = pNombreCurso;
        this.creditos = pCreditos;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }
    
    public Nodo(int codigo, String curso, int creditos, Nodo izq, Nodo der) {
        this.codigoCurso = codigo;
        this.nombreCurso = curso;
        this.creditos = creditos;
        this.nodoIzquierdo = izq;
        this.nodoDerecho = der;
    }
    
    public String toString(){
        return "Codigo curso: " + getCodigoCurso() + ", Nombre curso: " + getNombreCurso() + ", Creditos: " + getCreditos();
    }

    /**
     * @return the codigoCurso
     */
    public int getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * @param codigoCurso the codigoCurso to set
     */
    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    /**
     * @return the nombreCurso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * @param nombreCurso the nombreCurso to set
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the nodoIzquierdo
     */
    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    /**
     * @param nodoIzquierdo the nodoIzquierdo to set
     */
    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    /**
     * @return the nodoDerecho
     */
    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    /**
     * @param nodoDerecho the nodoDerecho to set
     */
    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }
    
    
}
