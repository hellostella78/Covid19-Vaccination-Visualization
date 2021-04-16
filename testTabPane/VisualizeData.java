import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class VisualizeData extends JPanel {
    private VaccineViewBundler viewBundler;
    private JButton vis;
    private PieChart locChart, typeChart;
    private BarChart locBar, typeBar;
    private JScrollPane scrollPane;
    private JPanel container;
    private CsvParserSimple parser;
    private VaccineController control;

    public VisualizeData() {
        vis = new JButton("visualize");
        vis.addActionListener(new ButtonListener());
        add(vis, BorderLayout.NORTH);

        locChart = new PieChart("Vaccine doses by Location (Pie)", new LinkedList<>(), new LinkedList<>());
      //  typeChart = new PieChart("Vaccine doses by Type (Pie)", new LinkedList<>(), new LinkedList<>());

       // locBar = new BarChart("Vaccine doses by Location (Bar)", new LinkedList<>(), new LinkedList<>());
        typeBar = new BarChart("Vaccine doses by Type (Bar)",new LinkedList<>(), new LinkedList<>());

      //  ex.PieChartbyLocation("pieeee", new LinkedList<>(), new LinkedList<>());
       // example = new PieChart("Bar Graph", total, inst);
        //create scroll pane and add table to it.
        container = new JPanel(new GridLayout(4,1));
        container.add(locChart.getContentPane());
        container.add(typeChart.getContentPane());
        container.add(locBar.getContentPane());
        container.add(typeBar.getContentPane());
        

		scrollPane = new JScrollPane();
        scrollPane.setViewportView(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(750,700));

        //add the scroll pane to panel.
		add(scrollPane, BorderLayout.SOUTH);

		// vis = new JButton("Refresh Graph");
		// vis.addActionListener(new ButtonListener());
		// add(vis, BorderLayout.NORTH);
    }

    public void visualizeData() throws Exception {
        LinkedList<String> totalLocation =  viewBundler.getController().getLocationsTotal();
        LinkedList<String> instLocation = viewBundler.getController().getLocationsInst();
        LinkedList<String> totalType = viewBundler.getController().getTypeTotal();
        LinkedList<String> instType = viewBundler.getController().getTypeInst();

        locChart = new PieChart("Vaccine doses by Location (Pie)", totalLocation, instLocation);
      //  typeChart = new PieChart("Vaccine doses by Type (Pie)", totalType, instType);  //INPUT INSTlOCATION AND TOTALLOCATION etc

      //  locBar = new BarChart("Vaccine doses by Location (Bar)", totalLocation, instLocation);
        typeBar = new BarChart("Vaccine doses by Type (Bar)", totalType, instType);
        //create scroll pane and add table to it.
		// scrollPane = new JScrollPane(example.getContentPane());

		//add the scroll pane to panel.
		// add(scrollPane);

		vis = new JButton("Refresh Graph");
		vis.addActionListener(new ButtonListener());
		add(vis, BorderLayout.NORTH);

        container = new JPanel(new GridLayout(4,1));
        container.add(locChart.getContentPane());
        container.add(typeChart.getContentPane());
        container.add(locBar.getContentPane());
        container.add(typeBar.getContentPane());
        // container.setPreferredSize(new Dimension(750,750));

		scrollPane = new JScrollPane();
        scrollPane.setViewportView(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(750,700));

        //add the scroll pane to panel.
		add(scrollPane, BorderLayout.SOUTH);

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
                remove(locChart);
                remove(typeChart);
                remove(container);
                remove(scrollPane);

		        // remove scroll pane
		        // if (scrollPane != null)
			    //     removeAll();

                visualizeData();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }
}
