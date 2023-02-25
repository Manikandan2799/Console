package contactmanagement;

public class Contact {
	private int id;
	private String name;
	private String contactNumber;
	private String DOB;
	private String emailId;
	private String address;

	public void setName(String name) {
		this.name = name;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getDOB() {
		return DOB;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ",name=" + name + ", contactNumber=" + contactNumber + ", DOB=" + DOB
				+ ", emailId=" + emailId + ", address=" + address + "]";
	}

	public Contact(int id, String name, String contactNumber, String dOB, String emailId, String address) {
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.DOB = dOB;
		this.emailId = emailId;
		this.address = address;
	}

	public Contact(String contactNumber, String name) {
		this.name = name;
		this.contactNumber = contactNumber;
	}
}
