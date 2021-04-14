import java.text.DecimalFormat;  
  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.PieSectionLabelGenerator;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset;  

import java.util.*;
import java.io.*;
import java.io.BufferedReader;

public class PieChartExample extends JFrame {  
  // private static final long serialVersionUID = 6294689542092367723L;  //??????????
  
  public PieChartExample(String title) {  
    super(title);  
  
    // Create dataset  
    PieDataset dataset = createDataset();  
  
    // Create chart  
    JFreeChart chart = ChartFactory.createPieChart(  
        "Pie Chart Example",  
        dataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        "Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
      
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private PieDataset createDataset(/*LinkedList<String> totalLocation, LinkedList<String> instLocation, LinkedList<String> totalType, LinkedList<String> instType*/) { 
    DefaultPieDataset dataset=new DefaultPieDataset();  
    
    //Location CHANGE THE DATSET VARIABLE 
    // for(int i = 0; i < instLocation.size(); i++){
    //   int count = getCount(totalLocation, instLocation.get(i));
    //   dataset.setValue(instLocation.get(i), count);
    // }

    // //Type
    // for(int i = 0; i < instType.size(); i++){
    //   getCount(totalType, instType.get(i));
    // }
    
    dataset.setValue("80-100", 120);  //dataset.setValue(instList, instList.count("type"))
    dataset.setValue("60-79", 80);  
    dataset.setValue("40-59", 20);  
    dataset.setValue("20-39", 7);  
    dataset.setValue("0-19", 3);  
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
  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(() -> {  
      PieChartExample example = new PieChartExample("Pie Chart Example");  
      PieChartExample example2 = new PieChartExample("Pie Chart Example2");  

      example.setSize(800, 400);  //Visual size 
      example.setLocationRelativeTo(null);  //visual 
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  

      example2.setSize(800, 400);  //Visual size 
      example2.setLocationRelativeTo(null);  //visual 
      example2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example2.setVisible(true);  
    });  
  }  
}  
