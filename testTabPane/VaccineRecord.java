public class VaccineRecord {
	
	private int id;
	private String firstName;
	private String lastName;
	private String vaxType;
	private String date;
	private String location;
	
	//simple constructor to store one user data type when instantiated
	public VaccineRecord(int id, String firstName, String lastName, String vaxType, String date, String location)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vaxType = vaxType;
		this.date = date;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
