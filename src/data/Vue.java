/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.util.Map;

/**
 *
 * @author Mikhali
 */
public class Vue {
    Portefeuille pf;
    
    Vue(){
        pf = new Portefeuille();
    }
    
    Vue(Portefeuille p){
        pf = p;
    }
    
    public void afficherFonds(){
        int i =0;
        System.out.println("Affichage de tout les fonds");
        
        for(Map.Entry affiche : pf.getFonds().entrySet()){
           i++;
           System.out.print("numero : " + i + " ");
           System.out.print("clé : " + affiche.getKey() + " " );
           Fond I = (Fond)affiche.getValue();
           I.afficher();
       }
        
        System.out.println("Fin d'Affichage de tout les fonds");
        System.out.println("");
    }
    
    public void afficherInstruments(){
       int i =0;
       for(Map.Entry affiche : pf.getInstruments().entrySet()){
           i++;
           System.out.println("numero " + i);
           System.out.println("clé : " + affiche.getKey());
           Instrument I = (Instrument)affiche.getValue();
           I.affichersimple();
           System.out.println("");
       }
    }
    
    public void afficherInstruments(String key){
        try{
            pf.chercherInstrument(key);
            Instrument I = pf.getInstruments().get(key);
            System.out.println("Instrument " + key);
            I.afficherall();
        }catch(InstrumentInexistant e){
            System.out.println("Fond introuvable");
        }
    }
    
    public void pourcentInstrument(String key){
        int k=0;
        try{
            pf.chercherInstrument(key);
            Instrument I = pf.getInstruments().get(key);
            for(int i = 0; i<I.getArray().size(); i++){
               for(Map.Entry actuelle : pf.getFonds().entrySet()){                  
                   if(I.getArray().get(i) == (Fond)actuelle.getValue()) k++;
                } 
            }
        }catch(InstrumentInexistant e){
            System.out.println("Fond introuvable");
        }
        System.out.println(k*100/pf.getFonds().size() + "%");
        
        System.out.println("");
    }
    
     public void listFond(){
       for(Map.Entry affiche : pf.getFonds().entrySet()){
           System.out.print(affiche.getKey() + " = ");
           Fond I = (Fond)affiche.getValue();
           I.afficher();
       }
       System.out.println("");
    }
    
    public void listInstrument(){
       for(Map.Entry affiche : pf.getInstruments().entrySet()){
           System.out.println(affiche.getKey());
       }
       System.out.println("");
    }
}
