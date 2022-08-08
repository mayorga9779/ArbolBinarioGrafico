/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.nodoarbol;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;
import org.umg.arbolbinario.ArbolBinario;

/**
 *
 * @author Edgar Mayorga
 */
public class SimuladorArbolBinario {
    ArbolBinario arbolB = new ArbolBinario();
    
    public SimuladorArbolBinario() {
        
    }

    /*
    Metodo para insertar todos los registros
    */
    public boolean insertar() {
        this.arbolB.agregar(25, "Electronica Analogica", 3);
        this.arbolB.agregar(22, "Metodos Numericos", 3);
        this.arbolB.agregar(23, "Programacion III", 4);
        this.arbolB.agregar(24, "Emprendedores de Negocios", 2);
        this.arbolB.agregar(28, "Base de Datos I", 3);
        this.arbolB.agregar(26, "Estadistica II", 3);
        this.arbolB.agregar(27, "Investigacion de Operaciones", 2);
        this.arbolB.agregar(29, "Lenguajes Formales y Automatas", 4);
        this.arbolB.agregar(16, "Calculo I", 3);
        
        return true;
    }
    //metodo para mostrar los recorridos del arbol
    public String preOrden() {
        ArrayList<Nodo> it = this.arbolB.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        ArrayList<Nodo> it = this.arbolB.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String postOrden() {
        ArrayList<Nodo> it = this.arbolB.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }
    
    //metodo para poder mostrar los tipos d recorrido
    private String recorrido(ArrayList<Nodo> it, String msg) {
        int i = 0;
        String r = msg + "\n\n";
        //System.out.println("Tamaño del arraylisst: " + it.size());
        while (i < it.size()) {
            ///r += "   " + it.get(i).getCodigoCurso().toString() + "";
            r = r + "Codigo:   " + it.get(i).getCodigoCurso() + "\n" +
                    "Curso:    " + it.get(i).getNombreCurso() + "\n" + 
                    "Creditos: " + it.get(i).getCreditos() + "\n" +
                    "___________________________________________________________\n";
            i++;
        }
        
        return (r);
    }
    
    public void eliminarNodo(int codigoCurso){
        this.arbolB.eliminar(codigoCurso);
    }
    
    public boolean estaVacio(){
        return arbolB.estaVacio();
    }
    
    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.arbolB.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    public JPanel getDibujo() {
        return this.arbolB.getdibujo();
    }
    
}
