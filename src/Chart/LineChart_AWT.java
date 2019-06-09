/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chart;
import java.util.Map;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {

   public LineChart_AWT( String applicationTitle , String chartTitle , Map<Integer,Integer> data) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Année","Nombre d'étudiant",
         createDataset(data),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( Map<Integer,Integer> data) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
      for(Map.Entry<Integer, Integer> entry : data.entrySet()){
        System.out.println(entry.getKey());
        dataset.addValue(entry.getValue() , "schools" , entry.getKey());
      }
      
      return dataset;
   }
   
   
}