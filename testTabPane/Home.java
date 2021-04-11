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
	private JTable table;

	public Home() {
		if (records != null)
			createTable();
		updateButton = new JButton("Display Table");
		updateButton.addActionListener(new ButtonListener());
		add(updateButton, BorderLayout.NORTH);		
	}

	public void createTable() {
		// remove scroll pane
		if (scrollPane != null)
			removeAll();

		// fetch records list
		records = viewBundler.getController().getRecordList();
		int recordsLength = records.size();

		String[] headers = {"ID", "Last Name", "First Name", "Vaccine Type", "Vaccine Date", "Vaccine Location"};
		String[][] entries = new String[recordsLength][6];

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
		table = new JTable(entries, headers);
		table.setPreferredScrollableViewportSize(new Dimension(750, 500));
		table.setFillsViewportHeight(true);

		//create scroll pane and add table to it.
		scrollPane = new JScrollPane(table);

		//add the scroll pane to panel.
		add(scrollPane);
	}

	//Home calls bundler to have access to controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == updateButton) {
				remove(updateButton);
				createTable();
				updateButton = new JButton("Refresh Table");
				updateButton.addActionListener(new ButtonListener());
				add(updateButton, BorderLayout.NORTH);

			}
		}
		
	}
}
