import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Celin Phang Sing Lin
 * Student ID: 22019543
 * Class: E65C
 * Date/Time Last modified:02/02/23
 */

public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		wardArr[0] = new Ward("A", "1 Bed, attached bath/toilet", 10, 535);
		wardArr[1] = new Ward("B1","4 Bed, attached bath/toilet", 20, 266.43);
		wardArr[2] = new Ward("B2","6 Bed, common bath/toilet", 20, 83);
		wardArr[3] = new Ward("C", "8 Bed, common bath/toilet", 50, 37);

		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		patientList.add(new Patient("111A", "John Lee","A", 2, "01/12/2022"));
		patientList.add(new Patient("222B", "Mary Jane","B1", 11 , "02/12/2022"));
		patientList.add(new Patient("333C", "Abdul Musri","B1", 12 , "03/12/2022"));
		patientList.add(new Patient("444D", "Jane Tan","B2", 2, "12/12/2022", "", 3));
		patientList.add(new Patient("555E", "Paul Tan","C", 2, "02/11/2022", "", 4));
		patientList.add(new Patient("666F", "Paul Ng", "C", 3, "03/11/2022", "09/11/2022",0));
		patientList.add(new Patient("777G", "Wong Kuan", "C", 4, "02/12/2022"));
		
		ArrayList<Visitors> visitorList = new ArrayList<Visitors>();
	
		//display standard menu and ask for option
		int option = -99;
		publicMenu();
		//indefinite while loop
		while(option != 9) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				//log out
				System.out.println("\nGood bye!");
			} else if (option == 10) {
				visitorEntries(patientList, wardArr, visitorList);
			}
				else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}
		
	} // end of main

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		
		System.out.println("1. View All Ward Info\n2. Display Patient List\n3. Admit Patient\n4. Discharge Patient\n5. Remove Patient\n6. Register Visit\n7. End Visit\n8. Display Ward Overview\n9. Logout\n10.Vistor Details");
		
	}
	
	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {
		Helper.line(80, "-");
		System.out.println("-----------------------------   WARD INFORMATION   -----------------------------");
		Helper.line(80, "-");
		System.out.println("");
		System.out.printf("%-10s%-35s%-20s%9s\n", "WARD", "DESCRIPTION", "BED COUNT", "BED CHARGE");
		Helper.line(80, "=");
		for (int i = 0; i < wardArr.length; i++) {
			System.out.printf("%-10s%-35s%-24d%-25.2f\n", wardArr[i].getWard(), wardArr[i].getDescription(),wardArr[i].getBedCount(), wardArr[i].getBedCharge());
			Helper.line(80, "-");
		}
		}

	//---------------------------------------------	----------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {
		Helper.line(110, "-");
		System.out.println("----------------------------------------------   PATIENT LIST   ----------------------------------------------");
		Helper.line(110, "-");
		System.out.println("");
		Helper.line(110, "=");
		System.out.printf("%-10s%-24s%-12s%-10s%-20s%-20s%-20s\n", "NRIC4", "Name", "Ward", "Bed", "Date Warded", "Date Discharged", "Visitor Count");
		Helper.line(110, "=");
		for (int i = 0; i < patientList.size(); i++) {
			System.out.printf("%-10s%-24s%-12s%-10s%-20s%-20s%7s\n", patientList.get(i).getNric4(), patientList.get(i).getName(), patientList.get(i).getWard(), patientList.get(i).getBed(), patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(), patientList.get(i).getVisitorCount());
			System.out.println("");
		}		
	}
	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {
		Helper.line(111, "-");
		System.out.println("----------------------------------------------   ADMIT PATIENT   ----------------------------------------------");
		Helper.line(111, "-");
		String newPNric4 = Helper.readString("Enter patient 4 digit Nric > " );
		String newPName = Helper.readString("Enter patient name > ");
		String newPWard = Helper.readString("Enter ward > ");
		int newPBed = Helper.readInt("Enter bed > ");
		String newPDW = Helper.readString("Enter date warded > ");
		patientList.add(new Patient(newPNric4, newPName, newPWard, newPBed, newPDW));
		
		System.out.println("");
		patientList.get(patientList.size()-1).display();
		System.out.println("");
		System.out.println("*** Patient has been added ***");
			
		}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {
		Helper.line(115, "-");
		System.out.println("----------------------------------------------   DISCHARGE PATIENT   ----------------------------------------------");
		Helper.line(115, "-");
		boolean patientfound = false;
		
		String pName = Helper.readString("Enter patient name > ");
		
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(pName) && patientList.get(i).getDateDischarged().isEmpty()) {
				System.out.println("");
				patientList.get(i).display();
				System.out.println("");
				String pDD = Helper.readString("Enter date discharged > ");
				patientList.get(i).setDateDischarged(pDD);
				patientList.get(i).setVisitorCount(0);;
				System.out.println("");
				System.out.println("*** Patient is discharged ***");
				patientfound = true;
			}
			
			else if (patientList.get(i).getName().equalsIgnoreCase(pName) && (patientList.get(i).getDateDischarged() != null)) {
				System.out.println("");
				System.out.println("*** Patient has already been discharged ***");
				patientfound = true;
			}
		}

		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {
		Helper.line(112, "-");
		System.out.println("----------------------------------------------   REMOVE PATIENT   ----------------------------------------------");
		Helper.line(112, "-");
		boolean patientfound = false;
		
		String pName = Helper.readString("Enter patient name > ");
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(pName)&& (patientList.get(i).getDateDischarged().isEmpty())){
				System.out.println("");
				patientList.get(i).display();
				System.out.println("");
				patientfound = true;
				
				char delete = Helper.readChar("Confirm Deletion (y/n) > ");
				if (delete == 'y' || delete == 'Y') {
					patientList.remove(i);
					System.out.println("");
					System.out.println("*** Patient has been deleted ***");
					patientfound = true;
				}
				
				else if (patientList.get(i).getName().equalsIgnoreCase(pName) && (patientList.get(i).getDateDischarged() != null)) {
					return patientfound;
				}
				}
	
		}
		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {
		Helper.line(110, "-");
		System.out.println("----------------------------------------------   REGISTER VISIT   ----------------------------------------------");
		Helper.line(110, "-");
		boolean patientfound = false;
		
		String pName = Helper.readString("Enter patient Name > ");
		
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(pName)&& (patientList.get(i).getDateDischarged().isEmpty())){
				System.out.println("");
				patientList.get(i).display();
				
				int VA = 4;
				patientList.get(i).getVisitorCount();
				patientfound = true; 
				
				if (patientList.get(i).getVisitorCount() < 4) {
					System.out.printf("\n*** Only %d visitor(s) allowed ***\n", VA);
					int v = Helper.readInt("\nEnter number of new visitors > ");
					if (v > VA) {
						System.out.println("\n*** Visitors exceeded ***");
					}
					else {
						patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount() + v);
						System.out.println("\n*** Please proceed to ward ***");
					}
				}
				else {
					System.out.println("\n*** No additional visitor allowed ***");
				}
				break;
			}
			else if (patientList.get(i).getName().equalsIgnoreCase(pName) && (patientList.get(i).getDateDischarged() != null)) {
				System.out.println("\n *** Patient has been discharged ***\n");
				patientfound = true;
				break;
			}
		}
		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {
		Helper.line(107, "-");
		System.out.println("----------------------------------------------   END VISIT   ----------------------------------------------");
		Helper.line(107, "-");
		boolean patientfound = false;

		String pName = Helper.readString("Enter patient name > ");

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(pName)&& (patientList.get(i).getDateDischarged().isEmpty())){
				System.out.println("");
				patientList.get(i).display();
				patientfound = true; 
				
				
				int vL = Helper.readInt("\nEnter number of visitor(s) leaving > ");
				if (vL > 4) {
					System.out.println("\n*** Visitor(s) leaving is more than visited ***");
					patientfound = true;
				}
				
				else if (patientList.get(i).getVisitorCount() >= vL ) {
					patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount() - vL);
					System.out.println("\n*** No of visitor(s) still at ward : " + patientList.get(i).getVisitorCount()+ " ***");
					patientfound = true;
				}
				else {
					System.out.println("\n*** No Such patient in ward ***");
				}
			}
			else if (patientList.get(i).getName().equalsIgnoreCase(pName) && (patientList.get(i).getDateDischarged() != null)) {
				System.out.println("\n *** Paitent has been discharged ***");
				patientfound = true;	
		}	
		}
		
		return patientfound;
	}

	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {
		Helper.line(153, "=");
		System.out.println("---------------------------------------------------------          WARD OVERVIEW          ---------------------------------------------------------------");
		Helper.line(153, "=");
		System.out.println();
		Helper.line(153, "=");
		System.out.printf("%-4s%-4s%4s %22s%15s %16s%3s %30s%4s %30s%4s\n" , "|","WARD","|", "DESCRIPTION","|","TOTAL BED COUNT FOR EACH WARD","|", "TOTAL PATIENTS FOR EACH WARD", "|","TOTAL VISITORS FOR EACH WARD", "|");
		Helper.line(153, "=");
		int TBC = 0;
		int TPAW = 0;
		int TVAW = 0;
		
		for (int i = 0; i < wardArr.length; i++) {
			int TPEW = 0;
			int TVEW = 0;
			
			for (int x = 0; x < patientList.size(); x++) {
				if(patientList.get(x).getWard().equals(wardArr[i].getWard()) && (patientList.get(x).getDateDischarged() == "")) {
					TPEW++;
					TVEW += patientList.get(x).getVisitorCount();
					
				}
			}
				System.out.printf("%-5s%-5s%2s %-27s%10s %16d%16s %17d%17s %17d%17s\n", "|", wardArr[i].getWard(),"|", wardArr[i].getDescription(),"|",wardArr[i].getBedCount(),"|", TPEW,"|", TVEW,"|");
				Helper.line(153,"-");
				
				TBC += wardArr[i].getBedCount();
				TPAW = patientList.size();
				TVAW += TVEW;
		}
				System.out.println("");
				Helper.line(107, "=");
				System.out.printf("%-3s%-16s%3s %30s%5s %30s%5s\n", "|","TOTAL BED COUNT FOR ALL WARDS","|", "TOTAL PATIENTS FOR ALL WARDS", "|","TOTAL VISITOR FOR ALL WARDS", "|");
				Helper.line(107, "=");
				System.out.printf("%-6s%13d%16s %17d%18s %17d%18s\n", "|", TBC, "|", TPAW, "|", TVAW, "|");
				Helper.line(107, "-");

}

	public static void visitorEntries(ArrayList<Patient> patientList, Ward[] wardArr,ArrayList<Visitors> visitorList) {
		Helper.line(111, "-");
		System.out.println("----------------------------------------------   VISITOR ENTRY   ----------------------------------------------");
		Helper.line(111, "-");
		String name = Helper.readString("Enter your name > ");
		String nric4 = Helper.readString("Enter nric4 > ");
		if (nric4.length() == 4) {
			String dateOfVisit = Helper.readString("Enter date of visit > ");
			String contactNo = Helper.readString("Enter contact number > ");
			if (contactNo.length() == 8) {
				String patientName = Helper.readString("Enter patient name > ");
				for (int i = 0; i < patientList.size(); i++) {
					if (patientList.get(i).getName().equalsIgnoreCase(patientName) && patientList.get(i).getDateDischarged().isEmpty()) {
						visitorList.add(new Visitors(name, nric4, contactNo, dateOfVisit, patientList.get(i).getWard(), patientList.get(i).getBed()));
						visitorList.get(visitorList.size()-1).display();
						System.out.println("\n*** Visitor's Details Recorded! ***");
					}
					else if (patientList.get(i).getName().equalsIgnoreCase(patientName) && patientList.get(i).getDateDischarged() != null) {
						System.out.println("\n*** Patient has been discharged ***");
					}
				}
			}
			else {
				System.out.println("*** Invalid Contact Number! ***");
			}
			
		}
		else {
			System.out.println("*** Invalid NRIC4! ***");
		}
		
		
		} // End of Visitor Entries
	
	
	
	
	
	
	
} // End of wardManagement 
			
			

	
	
	


	

		

