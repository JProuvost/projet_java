/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chart;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author Mikhali
 */

public class PieChart_AWT extends JFrame {
    /**
     * @param args the command line arguments
     */
    public PieChart_AWT( String title, Map<String,Integer> prof ) {
       super(title); 
       setContentPane(createDemoPanel(prof,title));
    }

    private static PieDataset createDataset(Map<String,Integer> prof) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
       
        for(Map.Entry<String, Integer> entry : prof.entrySet()){
            dataset.setValue(entry.getKey(), new Double(entry.getValue()));
        }
        return dataset;         
    }

    private static JFreeChart createChart(PieDataset dataset,String title) {
       JFreeChart chart = ChartFactory.createPieChart(      
          title,            // chart title 
          dataset,          // data    
          true,             // include legend   
          true, 
          false);

       return chart;
    }

    public static JPanel createDemoPanel(Map<String,Integer> prof,String title){
       JFreeChart chart = createChart(createDataset(prof),title);  
       return new ChartPanel( chart ); 
    }

    
}
