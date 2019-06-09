/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stat;
import data.*;
import Chart.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Mikhali
 */
public class Profratio extends IknowEcole{
    
    Map<String,Integer> prof = new HashMap<>();
    int annee;
    
    public Profratio(){
        super();
    }
    
    public Profratio(Ecole ecole, int idannee){
        super(ecole);
        annee = idannee;
        
        ArrayList<Classe> classe = new ArrayList<>();
        ArrayList<Enseignement> cours = new ArrayList<>();
        Map<Integer,Integer> counting = new HashMap<>();
        
        try{
            AnneeScolaire a = e.seekerAnnee(idannee);
            e.getmine(a, new ArrayList<Trimestre>(), classe);
            
            for(int i=0; i<classe.size(); i++){
                e.getmine(classe.get(i), cours, new ArrayList<Inscription>());
            }
        }catch(NotFoundException e){
            System.out.println("l'Annee ou les classes n'existe.s pas");            
        }
        
        int verify = 0;
        int verifybase = 0;
        
        for(int i = 0; i<cours.size(); i++){
            
            verify = 0;
            verifybase = 0;
            
            for(Map.Entry<Integer, Integer> entry : counting.entrySet()){
                if(entry.getKey() == cours.get(i).getidPersonne()){
                    int mod = entry.getValue()+1;
                    entry.setValue(mod);
                }else{
                    verify++;
                }
                verifybase++;
            }
            
            if(verify == verifybase){
                counting.put(cours.get(i).getidPersonne(), 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : counting.entrySet()){
            String name = "";
            try{
                Personne p = e.seekerPersonne(entry.getKey());
                name = p.getnom() + " " + p.getprenom();
            }catch(NotFoundException e){
                System.out.println("La personne n'existe pas");
            }
            prof.put(name, entry.getValue());
        }
    }
    
    public void fedetruc(){
        
       int fin  = annee +1; 
       PieChart_AWT cours = new PieChart_AWT( "Repartition des Cours " + annee + "-" + fin,prof);  
       cours.setSize( 560 , 367 );    
       RefineryUtilities.centerFrameOnScreen( cours );    
       cours.setVisible( true ); 
    }
}
