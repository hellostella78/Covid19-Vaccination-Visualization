import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.*;

public class PieChart extends JFrame {


  public PieChart(String title, LinkedList<String> total, LinkedList<String> inst) {
    super(title);

    // Create dataset
    PieDataset dataset = createDataset(total, inst);

    // Create chart
    JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);

    //Format Label
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator (
        "{0} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);


  }
 
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
  
}
