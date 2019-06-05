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
public class DetailBulletin {
    private int id;
    private int idbulletin;
    private int idenseignement;
    private String appreciation;
    
    public DetailBulletin(){
        
    }
    public DetailBulletin(int a, int b, int c, String d){
        id = a;
        idbulletin = b;
        idenseignement = c;
        appreciation = d;
    }
    public int get_id(){
        return id;
    }
    public int get_idbulletin(){
        return idbulletin;
    }
    public int get_idenseignement(){
        return idenseignement;
    }
    public String get_appreciation(){
        return appreciation;
    }
    public void set_id(int a)
    {
        id=a;
    }
    public void set_idbulletin(int a){
        idbulletin = a;
    }
    public void set_idenseignement(int a){
        idenseignement = a;
    }
    public void set_appreciation(String a){
        appreciation = a;
    }
}
