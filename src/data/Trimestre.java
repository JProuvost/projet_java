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
public class Trimestre extends idClasse {
    
    private int numero;
    private String debut;
    private String fin;
    private int idAnnee;
    
    public Trimestre(){
        
    }
    
    public Trimestre(int a, int b, String c, String d, int e){
        
        super(a);
        numero = b;
        debut = c;
        fin = d;
        idAnnee = e;
    }
    
    public int getidAnnee(){
        return idAnnee;
    }

    void changerdate(String d, String f) {
        debut = d;
        fin = f;
    }
    
}
