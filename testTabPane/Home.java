import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Home extends JPanel {

	private ArrayList<VaccineRecord> records;
	private JButton updateButton;
	private VaccineViewBundler viewBundler;
	private JScrollPane scrollPane;

	public Home() {
		initTable(0);
	}

	public void initTable(int recLength) {
		String[] headers = {"ID", "Last Name", "First Name", "Vaccine Type", "Vaccine Date", "Vaccine Location"};
		String[][] entries = new String[recLength][6];

		//populate entries
		for(int i=0; i<entries.length; i++) {
			entries[i][0] = records.get(i).getId();
			entries[i][1] = records.get(i).getLastName();
			entries[i][2] = records.get(i).getFirstName();
			entries[i][3] = records.get(i).getVaxType();
			entries[i][4] = records.get(i).getDate();
			entries[i][5] = records.get(i).getLocation();
		}

		//create table
		JTable table = new JTable(entries, headers);
		table.setPreferredScrollableViewportSize(new Dimension(750, 500));
		table.setFillsViewportHeight(true);

		//create scroll pane and add table to it.
		scrollPane = new JScrollPane(table);

		//add the scroll pane to panel.
		add(scrollPane);
		
		updateButton = new JButton("Refresh Table");
		updateButton.addActionListener(new ButtonListener());
		add(updateButton);
	}
	
	public void fetchRecords() {
		// remove button
		remove(updateButton);

<<<<<<< Updated upstream
	public JTable getJTable()
	{
		return table;
	}

=======
		// remove scroll pane
		if (scrollPane != null)
			removeAll();

		// fetch records list
		records = viewBundler.getController().getRecordList();
		int recordsLength = records.size();

		initTable(recordsLength);
	}
	
>>>>>>> Stashed changes
	//Home calls bundler to have access to controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == updateButton) {
				fetchRecords();
			}
		}
	}
}
