/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stat;

import Chart.LineChart_AWT;
import Chart.PieChart_AWT;
import data.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Mikhali
 */
public class evEleve extends IknowEcole{
    Map<Integer,Integer> evEtu = new HashMap<>();
    
    public evEleve(){
        super();
    }
    
    public evEleve(Ecole ecole){
        super(ecole);
        
        ArrayList<AnneeScolaire> annee = e.getannee();
        ArrayList<Inscription> inscrit = new ArrayList<>();
        ArrayList<Classe> classes = new ArrayList<>();
        
        for(int i = 1; i<annee.size(); i++){
            
            inscrit = new ArrayList<>();
            classes = new ArrayList<>();
            
            e.getmine(annee.get(i), new ArrayList<Trimestre>(), classes);
            
            for(int j = 0; j<classes.size(); j++){
                e.getmine(classes.get(j), new ArrayList<Enseignement>(), inscrit);
            }
            evEtu.put(annee.get(i).getid(),inscrit.size());
        }
        
    }
    
    public void fedetruc(){
        
       LineChart_AWT chart = new LineChart_AWT( "Evolution etudiant" , "Evolution du nombre d'Etudiants aux fil des années",evEtu);

       chart.pack( );
       RefineryUtilities.centerFrameOnScreen( chart );
       chart.setVisible( true );
    }
}
