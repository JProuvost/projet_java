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
public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String type;
    
    public Personne(){
        
    }
    public Personne(int a, String b, String c, String d){
        id = a;
        nom = b;
        prenom = c;
        type = d;
    }
    
    public int get_id(){
        return id;
    }
    public String get_nom(){
        return nom;
    }
    public String get_prenom(){
        return prenom;
    }
    public String get_type(){
        return type;
    }
    
    public void set_id(int a){
        id = a;
    }
    public void set_nom(String a){
        nom = a;
    }
    public void set_prenom(String a){
        prenom = a;
    }
    public void set_type(String a){
        type = a;
    }
}
