/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Chart.PieChart_AWT;
import java.util.HashMap;
import java.util.Map;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Mikhali
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main( String[ ] args ) {
       Map<String,Integer> prof = new HashMap<>();
       
       prof.put("Philibert", new Integer(10));
       prof.put("Henry", new Integer(6));
       prof.put("Josiane", new Integer(15));
       prof.put("Lea", new Integer(9));
       
       
       PieChart_AWT cours = new PieChart_AWT( "Cours dispensé",prof);  
       cours.setSize( 560 , 367 );    
       RefineryUtilities.centerFrameOnScreen( cours );    
       cours.setVisible( true ); 
    }
    
}
