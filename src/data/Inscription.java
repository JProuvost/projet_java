/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Jean
 */
public class Inscription extends idClasse {

    private int idClasse;
    private int idPersonne;
    
    public Inscription(){
    }
    
    public Inscription(int a, int b, int c){
        id = a;
        idClasse = b;
        idPersonne= c;
    }
    
    public int getidClasse(){
        return idClasse;
    }
    
    public int getidPersonne(){
        return idPersonne;
    }
    
}
