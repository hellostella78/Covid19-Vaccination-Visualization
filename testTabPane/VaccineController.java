import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//Main + Controller
public class VaccineController {
	
	//reference to view inside controller
	About about;
	AddData addData;
	LoadData loadData;
	
	ArrayList<VaccineRecord> vaxRecordList = new ArrayList<VaccineRecord>();
			
	public VaccineController(About about, AddData addData, LoadData loadData)
	{
		this.about = about;
		this.addData = addData;
		this.loadData = loadData;
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
		CsvParserSimple parseCSV = new CsvParserSimple();
	}
	
	//method to visualize record

}
