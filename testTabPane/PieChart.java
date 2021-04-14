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

public class PieChart extends JFrame {  

  private VaccineViewBundler viewBundler;
  private PieChart example;
  private CsvParserSimple parser;

  public PieChart(String title, LinkedList<String> total, LinkedList<String> inst) {  
    super(title);  
  
    // Create dataset  
    PieDataset dataset = createDataset(total, inst);  

    // Create chart  
    JFreeChart chart = ChartFactory.createPieChart(  
        "Number of doses by Location",  
        dataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator (  
        "{0} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
      
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel); 

    //dataset1
    // setSize(800, 400);  //Visual size 
    // setLocationRelativeTo(null);  //visual 
    // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
    // setVisible(true);  

    // setSize(800, 400);  //Visual size 
    // setLocationRelativeTo(null);  //visual 
    // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
    // setVisible(true); 
    
  }  
  
  /**
   * 
   * @param totalLocation
   * @param instLocation
   * @param totalType
   * @param instType
   * @return
   */
  private PieDataset createDataset(LinkedList<String> total, LinkedList<String> inst) { 
    DefaultPieDataset dataset = new DefaultPieDataset();  
    
    //Location CHANGE THE DATSET VARIABLE 
    for(int i = 0; i < inst.size(); i++){
      int count = getCount(total, inst.get(i));
      dataset.setValue(inst.get(i), count);
    }
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
  
  // public static void main(String[] args) {  
  //   SwingUtilities.invokeLater(() -> {  
  //     PieChartExample example = new PieChartExample("Pie Chart Example");  
  //     PieChartExample example2 = new PieChartExample("Pie Chart Example2");  

  //     // example.setSize(800, 400);  //Visual size 
  //     // example.setLocationRelativeTo(null);  //visual 
  //     // example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
  //     // example.setVisible(true);  

  //     // example2.setSize(800, 400);  //Visual size 
  //     // example2.setLocationRelativeTo(null);  //visual 
  //     // example2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
  //     // example2.setVisible(true);  
  //   });  
  // }  
}  
