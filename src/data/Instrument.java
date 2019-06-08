/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 931701524
 */
public class Instrument implements Serializable {
    public ArrayList<Fond> Fonds;
    
    Instrument(){
        Fonds= new ArrayList<>();
    }
    
    Instrument(ArrayList<Fond> a){
        Fonds = a;
    }
    
    public void ajouterFond(Fond a){
        Fonds.add(a);
    }
    
    public ArrayList<Fond> getArray(){
        return Fonds;
    }
    
    public void tri()
    {
        Collections.sort(Fonds);
    }
    
    public void afficherall(){
        double sumFond = 0;
        Fond f;
        System.out.println("nombre de Fonds : " + Fonds.size());
        for(int i = 0; i<Fonds.size(); i++){
            f = Fonds.get(i);
            System.out.print(i+1 + " : ");
            f.afficher();
            sumFond = sumFond + f.getmontant();
        }
        System.out.println("Totale : " + sumFond);
        System.out.println("");
    }
    
    public void affichersimple(){
        double sumFond = 0;
        Fond f;
        System.out.println("nombre de Fonds : " + Fonds.size());
        for(int i = 0; i<Fonds.size(); i++){
            f = Fonds.get(i);
            sumFond = sumFond + f.getmontant();
        }
        System.out.println("Totale : " + sumFond);
    }
}
