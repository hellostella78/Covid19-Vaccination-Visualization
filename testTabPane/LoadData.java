import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;

public class LoadData extends JPanel {

	private JFileChooser chooser;
	private JButton openButton;
	private JLabel loadLabel;
	private VaccineViewBundler viewBundler;
	private boolean loaded;

	public LoadData() {
		loaded = false;
		chooser = new JFileChooser();
		openButton = new JButton("Open File");
		openButton.addActionListener(new ButtonListener());
		loadLabel = new JLabel();

		// layout
		JPanel panel = new JPanel();
		panel.add(openButton);
		panel.add(loadLabel);
		add(panel, BorderLayout.PAGE_START);
	}

	//load view calls bundler to have access to controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

	public boolean getLoaded() {
		return loaded;
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == openButton) {
				int val = chooser.showOpenDialog(LoadData.this);
				if (val == JFileChooser.APPROVE_OPTION) {
					File csvFile = chooser.getSelectedFile();
					BufferedReader csvReader = null;
					try {
						csvReader = new BufferedReader(new FileReader(csvFile));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						loaded = true;
						viewBundler.getParser().parse(csvFile);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
