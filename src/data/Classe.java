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
public class Classe extends idClasse{
    
    private String nom;
    private int idNiveau;
    private int idAnnee;
    
    public Classe(){
        
    }
    
    public Classe(int a, String b, int c, int d)
    {
        super(a);
        nom=b;
        idNiveau=c;
        idAnnee=d;
    }
    
    public int getidAnnee(){
        return idAnnee;
    }
    
    public int getidNiveau(){
        return idNiveau;
    }
    
}