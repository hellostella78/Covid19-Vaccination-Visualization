import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class SaveData extends JPanel {

	private JFileChooser chooser;
	private JButton saveButton;
	private JLabel loadLabel;
	private VaccineViewBundler viewBundler;

	public SaveData() {
		chooser = new JFileChooser();
		saveButton = new JButton("Save File");
		saveButton.addActionListener(new ButtonListener());
		loadLabel = new JLabel();

		// layout
		JPanel panel = new JPanel();
		panel.add(saveButton);
		panel.add(loadLabel);
		add(panel, BorderLayout.PAGE_START);
	}

	//load view calls bundler to have access to controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == saveButton) {
                //auto-refresh Jtable before saving
		        viewBundler.getHome().createTable();
                //selects a file on-click
                chooser.setDialogTitle("Create a file to save to");
				int val = chooser.showOpenDialog(SaveData.this);
				if (val == JFileChooser.APPROVE_OPTION) {
					File csvFileToSave = chooser.getSelectedFile();
                    //try to get controller to save current jtable to file
					try {
                        FileWriter fileWrite = new FileWriter(csvFileToSave);
						BufferedWriter bufWrite = new BufferedWriter(fileWrite);
                        viewBundler.getController().saveData(bufWrite);

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }				
			}
		}
	}
}
