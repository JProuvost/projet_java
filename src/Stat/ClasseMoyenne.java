/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stat;

import Chart.BarChart_AWT;
import data.*;
import java.util.*;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Mikhali
 */
public class ClasseMoyenne extends IknowEcole{
    
    Map<String,Double> classes = new HashMap<>();
    int annee;
    
    public ClasseMoyenne(){
        super();
    }
    
    public ClasseMoyenne(Ecole ecole, int idannee, int idniveau){
        super(ecole);
        annee = idannee;
        
        ArrayList<Classe> classeA = new ArrayList<>();
        ArrayList<Classe> classeB = new ArrayList<>();
        ArrayList<Classe> classe = new ArrayList<>();
        
        try{
            AnneeScolaire a = e.seekerAnnee(idannee);
            Niveau b = e.seekerNiveau(idniveau);
            e.getmine(a, new ArrayList<Trimestre>(), classeA);
            e.getmine(b, classeB);
            
            classe = e.crossclasse(classeA, classeB);
            
        }catch(NotFoundException e){
            System.out.println("l'Annee ou les classes n'existe.s pas");            
        }
        
        
        
        for(int i = 0; i<classe.size(); i++){
            classes.put(classe.get(i).getnom(), e.MoyenneClasse(classe.get(i).getid()));
        }
    }
    
    public void fedetruc(){
        int fin = annee +1;
        BarChart_AWT chart = new BarChart_AWT("Classes Statistics", "Moyenne des classes " + annee + "-" + fin, classes);
        chart.pack( );
        chart.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( chart );       
        chart.setVisible( true ); 
    }
}
