import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//hello my friends

public class VaccineMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame ("Vaccinations");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// create panels
		//Home home = new Home();
		AddData addData = new AddData();
		LoadData loadData = new LoadData();
		About about = new About();

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

		VaccineController control = new VaccineController(about, addData, loadData);
	}

}
