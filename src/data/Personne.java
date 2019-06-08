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
public class Personne extends idClasse {
    
    private String nom;
    private String prenom;
    
    public Personne(){
        
    }
    
    public Personne(int a, String b, String c){
        
        super(a);
        nom = b;
        prenom = c;
    }
}
