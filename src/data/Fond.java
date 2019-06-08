/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.Serializable;

/**
 *
 * @author 931701524
 */
public class Fond implements Serializable , Comparable<Fond> {
    
    private double montant;
    
    Fond(){
        montant = 0;
    }
    
    Fond(double a){
        montant = a;
    }
    
    public double getmontant(){
        return montant;
    }
    
    public void afficher(){
        System.out.println(montant);
    }
    
    public boolean equals(Fond f)
    {
        if(this.montant == f.getmontant())
      {
          return(true);
      }else
      {
          return(false);
      }
    }
    
    @Override
    public int compareTo(Fond f)
    {
       if(this.montant >f.montant)
       {
           return 1;
       }else if(this.equals(f))
       {
           return 0;
       }else
       {
           return -1;
       }
    }
}
