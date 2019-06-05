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
public class Inscription {
    private int id;
    private int idclasse;
    private int ideleve;
    
    public Inscription(){
    }
    public Inscription(int a, int b, int c){
        id = a;
        idclasse = b;
        ideleve = c;
    }
    
    public int get_id(){
        return id;
    }
    public int get_idclasse(){
        return idclasse;
    }
    public int get_ideleve(){
        return ideleve;
    }
    
    public void set_id(int a){
        id = a;
    }
    public void set_idclasse(int a){
        idclasse = a;
    }
    public void set_ideleve(int a){
        ideleve = a;
    }
}
