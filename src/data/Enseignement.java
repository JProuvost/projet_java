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
public class Enseignement extends idClasse {
    
    private int idClasse;
    private int idDiscipline;
    private int idPersonne;
    
    public Enseignement(){    
    
    }
    
    public Enseignement(int a, int b, int c, int d){
        
        super(a);
        idDiscipline = b;
        idClasse = c;
        idPersonne = d;
    }
    
    public int getidClasse(){
        return idClasse;
    }
    
    public int getidPersonne(){
        return idPersonne;
    }
    
    public int getidDiscipline(){
        return idDiscipline;
    }
}
