import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

//Main + Controller
public class VaccineController {

	private VaccineViewBundler viewBundler;	//reference to view inside controller
	private ArrayList<VaccineRecord> vaxRecordList = new ArrayList<VaccineRecord>();

	//this methods sets the viewBundler instantiated in main such that
	//controller has access to all of the view panes, and manipulate accordingly
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

	//method to add new record
	public void addNewRecord(VaccineRecord newRecord)
	{
		//add to array list of persistent vaccine records
		vaxRecordList.add(newRecord);
		printRecordList();

		//change view of home after button submitted in table format	
		viewBundler.getAddData().clearFields();	
	}
	
	//method to add new record from Parser
	public void addNewLoadRecord(VaccineRecord newRecord)
	{
		//add to array list of persistent vaccine records
		vaxRecordList.add(newRecord);
		printRecordList();
	}

	//helper function to print out record array list
	public void printRecordList()
	{
		System.out.println("---------------Vaccination Record List----------------");
		for(int i = 0; i < vaxRecordList.size(); i++)
		{
			System.out.println(vaxRecordList.get(i).toString()); //test
		}
	}
	
	//method to save current updated record to file by sending jTable into a .csv format
	public void saveData(BufferedWriter bufWrite)
	{
		//retrieve jtable
		JTable updatedTable = viewBundler.getHome().getJTable();

		try {
			
			//save column names for first row
			for (int i = 0; i < updatedTable.getColumnCount(); i++) {
				if(i != updatedTable.getColumnCount()-1)
					bufWrite.write(updatedTable.getColumnName(i) + ",");
				else
				bufWrite.write(updatedTable.getColumnName(i));
			}
			bufWrite.newLine();

			//nested for loop to iterate through updated jtable
			for(int row = 0; row < updatedTable.getRowCount(); row++)
			{
				for(int col = 0; col < updatedTable.getColumnCount(); col++)
				{	//condiiton eliminates last comma
					if((col != updatedTable.getColumnCount()-1))
					{
						bufWrite.write(updatedTable.getValueAt(row, col).toString() + ",");
					}						
					else
						bufWrite.write(updatedTable.getValueAt(row, col).toString());
				}
				bufWrite.newLine();
			}
			bufWrite.close();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	//method to load record
	public void LoadData() {
//		CsvParserSimple parseCSV = new CsvParserSimple();
	}
	
	//method to visualize record

	//method to get record list to populate table
	public ArrayList<VaccineRecord> getRecordList() {
		return vaxRecordList;
	}
	
}
