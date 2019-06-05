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
public class Niveau {
    private int id;
    private String nom;
    
    public Niveau(){
        
    }
    public Niveau(int a, String b){
        id = a;
        nom = b;
    }
    
    public int get_id(){
        return id;
    }
    public String get_nom(){
        return nom;
    }
    
    public void set_id(int a){
        id = a;
    }
    public void set_nom(String a){
        nom = a;
    }
}
