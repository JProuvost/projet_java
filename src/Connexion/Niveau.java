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
public class Niveau extends idClasse {
    
    private String nom;
    
    public Niveau(){
        
    }
    
    public Niveau(int a, String b){
        
        super(a);
        nom = b;
    }
    
    public String getnom(){
        return nom;
    }
    
}
