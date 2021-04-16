import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddData extends JPanel {

	private JLabel idLabel;
	private JLabel lastNameLabel;
	private JLabel firstNameLabel;
	private JLabel vaxTypeLabel;
	private JLabel vaxDateLabel;
	private JLabel vaxLocationLabel;
	private JLabel errorMessage;

	private JTextField idField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField vaxTypeField;
	private JTextField vaxDateField;
	private JTextField vaxLocationField;
	
	private JButton submitButton;
	private VaccineViewBundler viewBundler;

	public AddData() {
		idLabel = new JLabel("ID:");
		idField = new JTextField();
		
		lastNameLabel = new JLabel("Last name:");
		lastNameField = new JTextField();

		firstNameLabel = new JLabel("First name:");
		firstNameField = new JTextField(10);

		vaxTypeLabel = new JLabel("Vaccine type:");
		vaxTypeField = new JTextField(10);

		vaxDateLabel = new JLabel("Vaccine date:");
		vaxDateField = new JTextField(10);

		vaxLocationLabel = new JLabel("Vaccine location:");
		vaxLocationField = new JTextField(10);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ButtonListener());
		
		//error message
		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.red);

		// add components to panel
		add(idLabel);
		add(idField);
		add(lastNameLabel);
		add(lastNameField);
		add(firstNameLabel);
		add(firstNameField);
		add(vaxTypeLabel);
		add(vaxTypeField);
		add(vaxDateLabel);
		add(vaxDateField);
		add(vaxLocationLabel);
		add(vaxLocationField);
		add(errorMessage);
		add(submitButton);
		
		setLayout(new GridLayout(7,2));
	}

	//add view uses bundler to access controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

	//method clears all fields after submit
	public void clearFields() 
	{
		idField.setText("");
		lastNameField.setText("");
		firstNameField.setText("");
		vaxTypeField.setText("");
		vaxDateField.setText("");
		vaxLocationField.setText("");
	}

	//method to check for blank fields
	public Boolean checkBlankFields(){
		if(idField.getText().equals("") || lastNameField.getText().equals("") || firstNameField.getText().equals("") 
		|| vaxTypeField.getText().equals("") || vaxDateField.getText().equals("") || vaxLocationField.getText().equals(""))
			return true;
		return false;
	}
	
	private class ButtonListener implements ActionListener {

		//listens for the submit button click on the add pane 
		//and tells ViewBundler's controller to add this new record
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == submitButton) {
				//System.out.println(idField.getText()); //tester
				
				//check id if it exists in 
				Boolean match = false; Boolean isBlank = false;
				match = viewBundler.getController().checkId(idField.getText());
				isBlank = checkBlankFields();

				if(match){
					System.out.println("found a matching id. Cannot add");
					errorMessage.setText("ERROR: cannot add due to a matching ID in system.");
				}
				else if(isBlank){
					errorMessage.setText("ERROR: please fill all fields before submission.");
				}
				else{
					VaccineRecord newRecord = new VaccineRecord(idField.getText(), lastNameField.getText(), firstNameField.getText(), vaxTypeField.getText(), vaxDateField.getText(), vaxLocationField.getText());			
					viewBundler.getController().addNewRecord(newRecord);
					errorMessage.setText("");
				}
			}
		}
	}
}
