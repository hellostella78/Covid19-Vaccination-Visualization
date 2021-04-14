import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import java.util.*;

public class BarChart_AWT extends ApplicationFrame {
   
   public BarChart_AWT( String applicationTitle, LinkedList<String> total, LinkedList<String> inst) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         applicationTitle,           
         "Location",            
         "Number of doses",            
         createDataset(total, inst),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset(LinkedList<String> total, LinkedList<String> inst) {
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      //Location CHANGE THE DATSET VARIABLE 
    for(int i = 0; i < inst.size(); i++){
      int count = getCount(total, inst.get(i));
      dataset.addValue(count, inst.get(i), inst.get(i));
    }
         
      //dataset.addValue(int:count, string:locations_inst, string:locations_inst)
      return dataset; 
   }

   private int getCount(LinkedList<String> list, String inst) {
      int count = 0;
      for(int i = 0; i < list.size(); i++) {
        if((list.get(i).equals(inst))){ 
          count++;
        }
      }
      return count;
    }

   /*public static void main( String[ ] args ) {
      BarChart_AWT chart = new BarChart_AWT("Bar Graph", new LinkedList<>(), new LinkedList<>());
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }*/
}