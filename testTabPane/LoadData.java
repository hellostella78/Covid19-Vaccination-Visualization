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

public class LoadData extends JPanel {

	private JFileChooser chooser;
	private JButton openButton;
	private JLabel loadLabel;
	private VaccineViewBundler viewBundler;

	public LoadData() {
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
//					//Model m;
//					String row = new String();
//					String[] data = null;
//					ArrayList<String> list = new ArrayList<String>();
//					try {
//						while ((row = csvReader.readLine()) != null) {
//							data = row.split(",");
//							// do something with the data
//							list.addAll(Arrays.asList(data));
//						}
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//					try {
//						csvReader.close();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
//					for (String item: list) {
//						loadLabel.setText(loadLabel.getText() + item);
//						System.out.println(item);
//					}
					try {
//						CsvParserSimple parse = new CsvParserSimple(csvFile);
						viewBundler.getParser().parse(csvFile);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				/////
				
			}
		}

	}

}
