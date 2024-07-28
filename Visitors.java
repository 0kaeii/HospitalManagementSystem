
public class Visitors extends Patient {
	
	private String name;
	private String nric4;
	private String contact;
	private String dateVisit;
	
	public Visitors(String name, String nric4, String contact, String dateVisit, String ward, int bed) {
		super(ward,bed);
		this.name = name;
		this.nric4 = nric4;
		this.contact = contact;
		this.dateVisit = dateVisit;
	}

	public String getName() {
		return name;
	}

	public String getNric4() {
		return nric4;
	}

	public String getContact() {
		return contact;
	}

	public String getDateVisit() {
		return dateVisit;
	}
	
	public void display() {
		System.out.println("\nVistor name              : " + getName());
		System.out.println("NRIC4                    : " + getNric4());
		System.out.println("Contact Number           : " + getContact());
		System.out.println("Date of visit            : " + getDateVisit());
		System.out.println("Patient's ward           : " + getWard());
		System.out.println("Patient's bed number     : " + getBed());
}
}