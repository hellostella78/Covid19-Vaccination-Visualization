import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//Main + Controller
public class VaccineController {
	
	//reference to view inside controller
	private VaccineViewBundler viewBundler;
	
	ArrayList<VaccineRecord> vaxRecordList = new ArrayList<VaccineRecord>();
			
	public VaccineController()
	{
	}
	
	//method to add new record
	public void addNewRecord(VaccineRecord newRecord)
	{
		//add to array list of persistent vaccine records
		vaxRecordList.add(newRecord);
		
		//change view i.e. about.update();	
	}
	
	//method to save record
	
	
	//method to load record
	public void LoadData() {
//		CsvParserSimple parseCSV = new CsvParserSimple();
	}

	public void SetBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}
	
	//method to visualize record

}
