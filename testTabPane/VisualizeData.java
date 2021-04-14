import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.*;

public class VisualizeData extends JPanel {
    private VaccineViewBundler viewBundler;
    private JButton vis;
    private PieChart example;
    private JScrollPane scrollPane;
    private CsvParserSimple parser;
    private VaccineController control;

    public VisualizeData() {
        // vis = new JButton("visualize");
        // vis.addActionListener(new ButtonListener());
        // add(vis);
        
        example = new PieChart("Pie Chart ", new LinkedList<>(), new LinkedList<>());
        
      //  ex.PieChartbyLocation("pieeee", new LinkedList<>(), new LinkedList<>());
       // example = new PieChart("Bar Graph", total, inst);
        //create scroll pane and add table to it.
		scrollPane = new JScrollPane(example.getContentPane());

		//add the scroll pane to panel.
		add(scrollPane);
		
		vis = new JButton("Refresh Graph");
		vis.addActionListener(new ButtonListener());
		add(vis, BorderLayout.NORTH);
    }

    public void visualizeData() throws Exception {
        LinkedList<String> totalLocation =  viewBundler.getController().getLocationsTotal();
        LinkedList<String> instLocation = viewBundler.getController().getLocationsInst();
        LinkedList<String> totalType = viewBundler.getController().getTypeTotal();
        LinkedList<String> instType = viewBundler.getController().getTypeInst();

        example = new PieChart("Location Pie Chart", totalType, instType);  //INPUT INSTlOCATION AND TOTALLOCATION etc  
        example = new PieChart("Type Pie Chart", totalLocation, instLocation);
        //create scroll pane and add table to it.
		scrollPane = new JScrollPane(example.getContentPane());

		//add the scroll pane to panel.
		add(scrollPane);
		
		vis = new JButton("Refresh Graph");
		vis.addActionListener(new ButtonListener());
		add(vis, BorderLayout.NORTH);

    }

    //visualize uses bundler to access controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                // remove update button
		        remove(vis);
		
		        // remove scroll pane
		        if (scrollPane != null)
			        removeAll();

                visualizeData();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }
}