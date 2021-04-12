import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
			//call controller to save data to a typed file .csv
		
		}

	}

}
