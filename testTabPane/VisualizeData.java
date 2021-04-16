import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class VisualizeData extends JPanel {
    private VaccineViewBundler viewBundler;
    private JButton vis;
    private PieChart locChart;
    private BarChart typeBar;
    private JScrollPane scrollPane;
    private JPanel container;

    public VisualizeData() {
        vis = new JButton("Refresh Graph");
        vis.addActionListener(new ButtonListener());
        add(vis, BorderLayout.NORTH);

        locChart = new PieChart("Vaccine doses by Location (Pie)", new LinkedList<>(), new LinkedList<>());
        typeBar = new BarChart("Vaccine doses by Type (Bar)",new LinkedList<>(), new LinkedList<>());

        container = new JPanel(new GridLayout(2,1));
        container.add(locChart.getContentPane());
        container.add(typeBar.getContentPane());

		scrollPane = new JScrollPane();
        scrollPane.setViewportView(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(750,700));

        //add the scroll pane to panel.
		add(scrollPane, BorderLayout.SOUTH);
    }

    public void visualizeData() throws Exception {
        LinkedList<String> totalLocation =  viewBundler.getController().getLocationsTotal();
        LinkedList<String> instLocation = viewBundler.getController().getLocationsInst();
        LinkedList<String> totalType = viewBundler.getController().getTypeTotal();
        LinkedList<String> instType = viewBundler.getController().getTypeInst();

        locChart = new PieChart("Vaccine doses by Location (Pie)", totalLocation, instLocation);
        typeBar = new BarChart("Vaccine doses by Type (Bar)", totalType, instType);

		vis = new JButton("Refresh Graph");
		vis.addActionListener(new ButtonListener());
		add(vis, BorderLayout.NORTH);

        container = new JPanel(new GridLayout(2,1));
        container.add(locChart.getContentPane());
        container.add(typeBar.getContentPane());

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
                // remove components
		        remove(vis);
                remove(container);
                remove(scrollPane);

                visualizeData();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
