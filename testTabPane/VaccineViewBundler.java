import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VaccineViewBundler
{
    //Home home;
    //SaveData saveData;
    AddData addData;
    LoadData loadData;
    About about;
    VaccineController controller;

    public VaccineViewBundler()
    {
        addData = new AddData();
        loadData = new LoadData();
        about = new About();

		JFrame frame = new JFrame ("Vaccinations");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// add all panels to TabPane
		JTabbedPane tabPane = new JTabbedPane();
		//tabPane.addTab("Home", home);
		tabPane.addTab("Add Data", addData);
		tabPane.addTab("Load Data", loadData);
		tabPane.addTab("About", about);

		// set size of frame
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//		tabPane.setBounds(50,50,200,200);
		frame.add(tabPane);
		frame.setSize(400,400);
		frame.setVisible(true);

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

	public VaccineController getController() {
		return controller;
	}

	public void setController(VaccineController controller) {
		this.controller = controller;
	}


}