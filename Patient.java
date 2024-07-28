
public class Patient {

	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged; 
	private int visitorCount; 
	
	public Patient(String nric4, String name, String ward, int bed, String dateWarded, String dateDischarged, int visitorCount) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = dateDischarged; 
		this.visitorCount = visitorCount; 
	}
	public Patient(String nric4, String name, String ward, int bed, String dateWarded) {
		this.nric4 = nric4;
		this.name = name; 
		this.ward = ward; 
		this.bed = bed; 
		this.dateWarded = dateWarded; 
		dateDischarged = "";
		visitorCount = 0;
	}
	
	public Patient(String ward, int bed) {
		this.ward = ward;
		this.bed = bed;
	}
	
	public String getNric4() {
		return nric4;
	}
	public String getName() {
		return name;
	}
	public String getWard(){
		return ward;
	}
	public int getBed() {
		return bed;
	}
	public String getDateWarded() {
		return dateWarded;
	}
	public String getDateDischarged() {
		return dateDischarged;
	}
	public int getVisitorCount() {
		return visitorCount;
	}
	public void setDateDischarged(String dateDischarged) {
		this.dateDischarged = dateDischarged;
	}
	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}
	public void display() {
		System.out.println("Patient name       : " + getName());
		System.out.println("Ward               : " + getWard());
		System.out.println("Bed                : " + getBed());
		System.out.println("Date Warded        : " + getDateWarded());
		System.out.println("Date Discharge     : " + getDateDischarged());
		System.out.println("No of visitor(s)   : " + getVisitorCount());
	}
	
}
