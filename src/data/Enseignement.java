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
public class Enseignement {
    private int id;
    private int iddiscipline;
    private int idclasse;
    private int idpersonne;
    public Enseignement(){    
    }
    public Enseignement(int a, int b, int c, int d){
        id = a;
        iddiscipline = b;
        idclasse = c;
        idpersonne = d;
    }
    public int get_id(){
        return id;
    }
    public int get_iddiscipline(){
        return iddiscipline;
    }
    public int get_idclasse(){
        return idclasse;
    }
    public int get_idpersonne(){
        return idpersonne;
    }
    public void set_id(int a){
        id = a;
    }
    public void set_iddiscipline(int a){
        iddiscipline= a;
    }
    public void set_idclasse(int a){
        idclasse = a;
    }
    public void set_idpersonne(int a){
        idpersonne = a;
    }
}
