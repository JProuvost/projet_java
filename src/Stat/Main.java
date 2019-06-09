/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stat;

import data.*;
import java.util.HashMap;
import java.util.Map;
import Chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Mikhali
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Ecole e = new Ecole();
        e.addAnnee();
        e.addAnnee();
        e.addAnnee();

        e.addNiveau("5e");

        e.addClasse("5e1", 1, 1);
        e.addClasse("5e2", 1, 1);
        e.addClasse("5e3", 1, 1);
        e.addClasse("5e4", 1, 1);
        
        e.addClasse("5e1", 1, 2);
        e.addClasse("5e2", 1, 2);
        e.addClasse("5e3", 1, 2);
        e.addClasse("5e4", 1, 2);
        
        e.addClasse("5e1", 1, 3);
        e.addClasse("5e2", 1, 3);
        e.addClasse("5e3", 1, 3);
        e.addClasse("5e4", 1, 3);

        e.addDiscipline("math");
        e.addDiscipline("phisique");

        e.addPersonne("louis", "paul", "enseignant");
        e.addPersonne("laure", "hiver", "enseignant");
        e.addPersonne("lucas", "delaclasse", "enseignant");
        e.addPersonne("filipine", "DOM", "enseignant");
        e.addPersonne("mikha", "terre", "enseignant");

        e.addEnseignement(1, 1, 1);
        e.addEnseignement(2, 1, 1);
        e.addEnseignement(1, 2, 1);
        e.addEnseignement(2, 2, 1);
        e.addEnseignement(1, 3, 1);
        e.addEnseignement(2, 3, 1);
        e.addEnseignement(1, 4, 1);
        e.addEnseignement(2, 4, 1);

        e.addPersonne("delablasse", "calus", "eleve");
        e.addPersonne("leba", "jerem", "eleve");
        e.addPersonne("rabdoul", "edouard", "eleve");
        e.addPersonne("dfa", "hinda", "eleve");
        e.addPersonne("jean", "luc", "eleve");
        e.addPersonne("filipini", "leonardo", "eleve");
        e.addPersonne("bitra", "kale", "eleve");
        e.addPersonne("treer", "makhi", "eleve");
        e.addPersonne("cyka", "bliat", "eleve");

        e.addInscription(1, 1);
        e.addInscription(2, 4);
        e.addInscription(4, 5);
        e.addInscription(3, 5);
        
        e.addInscription(5, 1);
        e.addInscription(5, 2);
        e.addInscription(8, 3);
        e.addInscription(6, 4);
        e.addInscription(6, 5);
        e.addInscription(6, 6);
        e.addInscription(7, 7);
        
        e.addInscription(9, 1);
        e.addInscription(9, 2);
        e.addInscription(9, 3);
        e.addInscription(10, 4);
        e.addInscription(10, 5);
        e.addInscription(10, 6);
        e.addInscription(11, 7);
        e.addInscription(12, 8);
        e.addInscription(12, 9);
        
        

        e.addEvaluation(1, 12, "");
        e.addEvaluation(1, 15, "");
        e.addEvaluation(2, 9, "");
        e.addEvaluation(2, 2, "");
        e.addEvaluation(3, 12, "");
        e.addEvaluation(4, 19, "");
        e.addEvaluation(6, 20, "");
        e.addEvaluation(6, 15, "");
        e.addEvaluation(6, 16, "");
        e.addEvaluation(7, 6, "");
        e.addEvaluation(8, 12, "");
        e.addEvaluation(9, 11, "");
        e.addEvaluation(9, 16, "");
        e.addEvaluation(10, 4, "");
        e.addEvaluation(10, 7, "");
        e.addEvaluation(10, 19, "");
        e.addEvaluation(11, 15, "");
        e.addEvaluation(12, 12, "");
        e.addEvaluation(12, 11, "");
        e.addEvaluation(13, 16, "");
        e.addEvaluation(14, 4, "");
        e.addEvaluation(15, 7, "");
        e.addEvaluation(16, 19, "");
        e.addEvaluation(17, 15, "");
        e.addEvaluation(18, 12, "");
        e.addEvaluation(19, 11, "");
        e.addEvaluation(20, 16, "");
        e.addEvaluation(21, 4, "");
        e.addEvaluation(22, 7, "");
        e.addEvaluation(50, 19, "");
        e.addEvaluation(51, 15, "");
        e.addEvaluation(52, 7, "");
        e.addEvaluation(26, 19, "");
        e.addEvaluation(27, 15, "");
        e.addEvaluation(27, 7, "");
        e.addEvaluation(26, 19, "");
        e.addEvaluation(12, 15, "");
        e.addEvaluation(28, 19, "");
        e.addEvaluation(29, 15, "");
        e.addEvaluation(30, 12, "");
        e.addEvaluation(31, 11, "");
        e.addEvaluation(32, 16, "");
        e.addEvaluation(33, 4, "");
        e.addEvaluation(34, 7, "");
        e.addEvaluation(35, 19, "");
        e.addEvaluation(36, 15, "");
        e.addEvaluation(37, 12, "");
        e.addEvaluation(38, 11, "");
        e.addEvaluation(39, 16, "");
        e.addEvaluation(40, 4, "");
        e.addEvaluation(41, 7, "");
        e.addEvaluation(42, 19, "");
        e.addEvaluation(43, 15, "");
        e.addEvaluation(44, 7, "");
        e.addEvaluation(45, 19, "");
        e.addEvaluation(46, 15, "");
        e.addEvaluation(47, 7, "");
        e.addEvaluation(48, 19, "");
        e.addEvaluation(49, 15, "");
        e.addEvaluation(50, 15, "");
        e.addEvaluation(51, 7, "");
        e.addEvaluation(52, 19, "");
        e.addEvaluation(53, 15, "");
        e.addEvaluation(54, 7, "");
        e.addEvaluation(55, 19, "");
        e.addEvaluation(53, 15, "");
        
                
        evEleve eve = new evEleve(e);
        eve.fedetruc();
        
    }
      
}
