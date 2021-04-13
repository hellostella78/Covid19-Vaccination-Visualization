import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VaccineViewBundler
{
    private Home home;
    private SaveData saveData;
    private AddData addData;
    private LoadData loadData;
	private VisualizeData visualize;
    private About about;
    private CsvParserSimple csv;
    private VaccineController controller;

    public VaccineViewBundler() throws Exception
    {
		//instantiate view panes
    	home = new Home();
		saveData = new SaveData();
        addData = new AddData();
        loadData = new LoadData();
		visualize = new VisualizeData();
        about = new About();
        csv = new CsvParserSimple();

		//set view bundlers for eahc of the view panes
        home.setBundler(this);
		addData.setBundler(this);
		loadData.setBundler(this);
		saveData.setBundler(this);
		visualize.setBundler(this);
		csv.setBundler(this);

		JFrame frame = new JFrame ("Vaccinations");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// add all panels to TabPane
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.addTab("Display Table", home);
		tabPane.addTab("Add Data", addData);
		tabPane.addTab("Load Data", loadData);
		tabPane.addTab("Save Data", saveData);
		tabPane.addTab("Visualize Data", visualize);
		tabPane.addTab("About", about);

		// set size of frame
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//		tabPane.setBounds(50,50,200,200);
		frame.add(tabPane);
		frame.setSize(800,800);
		frame.setVisible(true);

    }

	public void setController(VaccineController controller) {
		this.controller = controller;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public SaveData getSaveData() {
		return saveData;
	}

	public void setSaveData(SaveData saveData) {
		this.saveData = saveData;
	}

	public AddData getAddData() {
		return addData;
	}

	public void setAddData(AddData addData) {
		this.addData = addData;
	}

	public LoadData getLoadData() {
		return loadData;
	}

	public void setLoadData(LoadData loadData) {
		this.loadData = loadData;
	}

	public About getAbout() {
		return about;
	}

	public void setAbout(About about) {
		this.about = about;
	}
	
	public CsvParserSimple getParser() {
		return csv;
	}

	public void setParser(CsvParserSimple csv) {
		this.csv = csv;
	}
	
	public VaccineController getController() {
		return this.controller;
	}
}