import javax.swing.JPanel;

public class VisualizeData extends JPanel {
    private VaccineViewBundler viewBundler;
<<<<<<< Updated upstream
    
    public VisualizeData() {

=======
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

>>>>>>> Stashed changes
    }

    //visualize uses bundler to access controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

}
