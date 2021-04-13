import javax.swing.JPanel; 
import javax.swing.SwingUtilities;  
import java.util.*;

public class VisualizeData extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private VaccineViewBundler viewBundler;
    
    public VisualizeData() throws Exception {
        SwingUtilities.invokeLater(() -> {
            LinkedList<String> totalLocation;
            try {
                totalLocation = viewBundler.getParser().getLocationsTotal();
            } catch (Exception e) {
                totalLocation = null;
                e.printStackTrace();
            }  
            LinkedList<String> instLocation;
            try {
                instLocation = viewBundler.getParser().getLocationsInst();
            } catch (Exception e) {
                instLocation = null;
                e.printStackTrace();
            }  

            PieChart example = new PieChart("Pie Chart Example", totalLocation, instLocation);  //INPUT INSTlOCATION AND TOTALLOCATION etc  

            

            // example.setSize(800, 400);  //Visual size 
            // example.setLocationRelativeTo(null);  //visual 
            // example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
            // example.setVisible(true);  
            
            // layout
            add(example);
            // example2.setSize(800, 400);  //Visual size 
            // example2.setLocationRelativeTo(null);  //visual 
            // example2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
            // example2.setVisible(true);  
        });
    }

    //visualize uses bundler to access controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

}
