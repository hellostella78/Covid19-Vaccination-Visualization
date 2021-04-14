import javax.swing.JButton;
import javax.swing.JPanel; 
import javax.swing.SwingUtilities;  
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VisualizeData extends JPanel {

    private VaccineViewBundler viewBundler;
    private JButton vis;
    private PieChart example;
    private JScrollPane scrollPane;
    
    public VisualizeData() {
        // vis = new JButton("visualize");
        // vis.addActionListener(new ButtonListener());
        // add(vis);
        example = new PieChart("Pie Chart Example", new LinkedList<>(), new LinkedList<>());

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

        example = new PieChart("Location Pie Chart", totalLocation, instLocation);  //INPUT INSTlOCATION AND TOTALLOCATION etc  

        //create scroll pane and add table to it.
		scrollPane = new JScrollPane(example.getContentPane());

		//add the scroll pane to panel.
		add(scrollPane);
		
		vis = new JButton("Refresh Graph");
		vis.addActionListener(new ButtonListener());
		add(vis, BorderLayout.NORTH);


        // example.setSize(800, 400);  //Visual size 
        // example.setLocationRelativeTo(null);  //visual 
        // example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        // example.setVisible(true);  
        
        // layout
        // example2.setSize(800, 400);  //Visual size 
        // example2.setLocationRelativeTo(null);  //visual 
        // example2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        // example2.setVisible(true);  
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
