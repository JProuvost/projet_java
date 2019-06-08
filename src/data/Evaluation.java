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
public class Evaluation extends idClasse {
    
    int idDetailBulletin;
    double note;
    String appreciation;
    
    Evaluation(){
        
    }
    
    Evaluation(int a, int b, double c, String d){
        
        super(a);
        idDetailBulletin = b;
        note = c;
        appreciation = d;
    }
    
    public int getidDetailBulletin(){
        return idDetailBulletin;
    }
    
    public double getnote(){
        return note;
    }
}
