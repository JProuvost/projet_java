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
public class DetailBulletin extends idClasse{
    
    private int idBulletin;
    private int idEnseignement;
    private String appreciation;
    
    public DetailBulletin(){
        
    }
    
    public DetailBulletin(int a, int b, int c, String d){
        id = a;
        idBulletin = b;
        idEnseignement = c;
        appreciation = d;
    }
    
    public int getidBulletin(){
        return idBulletin;
    }
    
    public int getidEnseignement(){
        return idEnseignement;
    }
    
}
