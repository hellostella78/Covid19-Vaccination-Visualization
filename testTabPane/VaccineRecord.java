public class VaccineRecord {
	
	private String id;
	private String firstName;
	private String lastName;
	private String vaxType;
	private String vaxDate;
	private String vaxLocation;
	
	//simple constructor to store one user data type when instantiated
	public VaccineRecord(String id, String lastName, String firstName, String vaxType, String vaxDate, String vaxLocation)
	{
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.vaxType = vaxType;
		this.vaxDate = vaxDate;
		this.vaxLocation = vaxLocation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getVaxType() {
		return vaxType;
	}

	public void setVaxType(String vaxType) {
		this.vaxType = vaxType;
	}

	public String getDate() {
		return vaxDate;
	}

	public void setDate(String vaxDate) {
		this.vaxDate = vaxDate;
	}

	public String getLocation() {
		return vaxLocation;
	}

	public void setLocation(String vaxLocation) {
		this.vaxLocation = vaxLocation;
	}
	
	public String toString()
	{
		return "\nID: " + id 
			+ "\nLast Name: " + lastName
			+ "\nFirst Name: " + firstName
			+ "\nVaccine Type: " + vaxType
			+ "\nVaccine Date: " + vaxDate
			+ "\nVaccine Location: " + vaxLocation
			+ "\n";
	}
	
	
}
