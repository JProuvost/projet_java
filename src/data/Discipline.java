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
public class Discipline extends idClasse{
    
    String nom;
    
    public Discipline(){
        
    }
    
    public Discipline(int a, String name)
    {
        super(a);
        nom = name;
    }
    
    public String getnom(){
        return nom;
    }
}
