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
public class Bulletin extends idClasse{
    
    private int idTrimestre;
    private int idInscription;
    private String appreciation;
    
    public Bulletin(){
        
    }
    
    public Bulletin(int a , int b, int c, String d)
    {
        super(a);
        idInscription = b;
        idTrimestre = c;
        appreciation = d;
    }
    
    public int getidTrimestre(){
        return idTrimestre;
    }
    
    public int getidInscription(){
        return idInscription;
    }
    
}
