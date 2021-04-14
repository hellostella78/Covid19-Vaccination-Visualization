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

//private VaccineViewBundler viewBundler;
//private JButton vis;
//private PieChart example;
//private JScrollPane scrollPane;
 //private CsvParserSimple parser;

public class PieChartExample extends JFrame {  
  CsvParserSimple parser = new CsvParserSimple();
  //constructor
  public PieChartExample(String title) {  
    super(title);  
  }  
 
  public void PieChartbyLocation(String title, LinkedList<String> total, LinkedList<String> inst) {  
    // Create dataset  
    PieDataset dataset = createDataset();  //change createDataset() to createDatasetLocation()
  
    // Create chart  
    JFreeChart chart = ChartFactory.createPieChart(
        "Number of doses by Location",  
        dataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        "{0} {2}", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
      
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel); 
  }

  public void PieChartbyType(String title) {  

    // Create dataset  
    PieDataset dataset = createDataset();  //change createDataset() to createDatasetType()
  
    // Create chart  
    JFreeChart chart = ChartFactory.createPieChart(  
        "Number of doses by Vaccine Type",  
        dataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        "{0} {2}", new DecimalFormat("0"), new DecimalFormat("0%"));  
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
    // it doesnt work because data's not imported yet
    for(int i = 0; i < parser.one_inst_locations.size(); i++) {
      dataset.setValue(parser.one_inst_locations.get(i),getCount(parser.total_locations, parser.one_inst_locations.get(i)));
    }
    //dataset.setValue(locationName, each dose count)
  
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
    CsvParserSimple parser = new CsvParserSimple();
    
    //SwingUtilities.invokeLater(() -> {  
      PieChartExample example = new PieChartExample("Number of doses by Location");  
      PieChartExample example2 = new PieChartExample("Number of doses by Vaccine Type"); 

      //example.PieChartbyLocation("Number of doses by Location");
      example.setSize(800, 400);  //Visual size 
      example.setLocationRelativeTo(null);  //visual 
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  

      example2.PieChartbyType("Number of doses by Vaccine Type");
      example2.setSize(800, 400);  //Visual size 
      example2.setLocationRelativeTo(null);  //visual 
      example2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example2.setVisible(true);  
    //});  
  }  
}  
