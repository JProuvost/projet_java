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
public class Trimestre {
    private int id;
    private int numero;
    private String debut;
    private String fin;
    private int idannee;
    
    public Trimestre(){
        
    }
    public Trimestre(int a, int b, String c, String d, int e){
        id = a; 
        numero = b;
        debut = c;
        fin = d;
        idannee = e;
    }
    
    public int get_id(){
        return id;
    }
    public int get_numero(){
        return numero;
    }
    public String get_debut(){
        return debut;
    }
    public String get_fin(){
        return fin;
    }
    public int get_idannee(){
        return idannee;
    }
    public void set_id(int a){
        id = a;
    }
    public void set_numero(int a){
        numero = a;
    }
    public void set_debut(String a){
        debut = a;
    }
    public void set_fin(String a){
        fin = a;
    }
    public void set_idannee(int a){
        idannee = a;
    }
}
