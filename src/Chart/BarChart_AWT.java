/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chart;

import com.orsoncharts.Range;
import java.util.Map;
import javafx.scene.chart.NumberAxis;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;


/**
 *
 * @author Mikhali
 */

public class BarChart_AWT extends JFrame {

    public BarChart_AWT( String applicationTitle , String chartTitle, Map<String,Double> classes) {
        super( applicationTitle );        
        JFreeChart barChart = ChartFactory.createBarChart(
            chartTitle,           
            "Moyenne",            
            "Note",            
            createDataset(classes),          
            PlotOrientation.VERTICAL,           
            true, true, false);
        
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        ValueAxis valueAxis = plot.getRangeAxis();
        valueAxis.setRange(0, 20);
        
        ChartPanel chartPanel = new ChartPanel( barChart );        
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
        setContentPane( chartPanel ); 
    }

    private CategoryDataset createDataset(Map<String,Double> classes) {
            
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        
        for(Map.Entry<String, Double> entry : classes.entrySet()){
            dataset.addValue( entry.getValue() , entry.getKey() ,"");
        }
        
        return dataset; 
    }
}
