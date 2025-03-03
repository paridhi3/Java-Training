package HMSystem;
 
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
 
public class HMSApp {
	
	public static void managePatient(Scanner sc) throws SQLException {
		while(true) {
		System.out.println("Enter your Choice:");
		System.out.println("Press 1: Insert New Patient detail");
		System.out.println("Press 2: Update Patient detail");
		System.out.println("Press 3: Delete Patient detail");
		System.out.println("Press 4: View All Patients");
		
		int choice = sc.nextInt();
			switch(choice) {
			case 1:
				PatientDAO.addPatient(enterDetailsPatient(sc));
				break;
			case 2:
				System.out.println("Enter patient id to update: ");
				int id = sc.nextInt();
				sc.nextLine();
				PatientDAO.updatePatient(id, enterDetailsPatient(sc));
				break;
			case 3:
				System.out.println("Enter patient id to update: ");
				int id2 = sc.nextInt();
				PatientDAO.deletePatient(id2);
				break;
			case 4:
				List<Patient> patients = PatientDAO.getAllPatients();
	            System.out.println("Patients in the database:");
	            for (Patient patient : patients) {
	                System.out.println("First Name: " + patient.getFname() +
	                                   "\nLast Name: " + patient.getLname() +
	                                   "\nAge: " + patient.getAge() +
	                                   "\nGender: " + patient.getGender() +
	                                   "\nContact Number: " + patient.getContactNumber());
	                System.out.println("===========================================================");
	            }
	            System.out.println("===========================================================");
	            break;
			case 5:
				System.out.println("Exiting from the system!");
                sc.close();
                return;
            default:
                System.out.println("Enter valid choice (1-5): ");
                System.out.println("================================");
                System.out.println("");
			}
		}
	}
	
	public static Patient enterDetailsPatient(Scanner sc) {
		System.out.println("Enter your details.");
		System.out.println("Enter first name:");
		String fname = sc.next();
		System.out.println("Enter Last name:");
		String lname = sc.next();
		System.out.println("Enter age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Gender:");
		String gender = sc.next();
		System.out.println("Enter contact Number:");
		String contactnumber = sc.next();
		Patient p = new Patient(fname,lname,age,gender,contactnumber);
		return p;
	}
	
	public static void manageDoctor(Scanner sc) throws SQLException {
		while(true) {
		System.out.println("Enter your Choice:");
		System.out.println("Press 1: Insert New Doctor detail");
		System.out.println("Press 2: Update Doctor detail");
		System.out.println("Press 3: Delete Doctor detail");
		System.out.println("Press 4: View All Doctors");
		int choice = sc.nextInt();
			switch(choice) {
			case 1:
				DoctorDAO.addDoctor(enterDetailsDoctor(sc));
				break;
			case 2:
				System.out.println("Enter Doctor id to update: ");
				int id = sc.nextInt();
				DoctorDAO.updateDoctor(id, enterDetailsDoctor(sc));
				break;
			case 3:
				System.out.println("Enter Doctor id to update: ");
				int id2 = sc.nextInt();
				DoctorDAO.deleteDoctor(id2);
				break;
			case 4:
				List<Doctor> doctors = DoctorDAO.getAllDoctors();
	            System.out.println("Doctors in the database:");
	            for (Doctor doctor : doctors) {
	                System.out.println("First Name: " + doctor.getName() +
	                                   "\nAge: " + doctor.getSpeciality() +
	                                   "\nContact Number: " + doctor.getContact());
	                System.out.println("===========================================================");
	            }
	            System.out.println("===========================================================");
	            break;
			case 5:
				System.out.println("Exiting from the system!");
                sc.close();
                return;
            default:
                System.out.println("Enter valid choice (1-5): ");
                System.out.println("================================");
                System.out.println("");
			}
		}
	}
	
	public static Doctor enterDetailsDoctor(Scanner sc) {
		System.out.println("Enter your Updated details:");
		sc.nextLine();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter Speciality:");
		String speciality = sc.nextLine();
		System.out.println("Enter contact Number:");
		String contact = sc.nextLine();
		Doctor p = new Doctor(name,speciality,contact);
		return p;
	}
	
	public static void manageAppt(Scanner sc) throws SQLException {
		while(true) {
		System.out.println("Enter your Choice:");
		System.out.println("Press 1: Insert New Appointment detail");
		System.out.println("Press 2: Update Appointment detail");
		System.out.println("Press 3: Delete Appointment detail");
		System.out.println("Press 4: View All Appointment");
		int choice = sc.nextInt();
			switch(choice) {
			case 1:
				AppointmentDAO.addAppointment(enterDetailsAppt(sc));
				break;
			case 2:
				System.out.println("Enter Appointment id to update: ");
				int id = sc.nextInt();
				AppointmentDAO.updateAppointment(id, enterDetailsAppt(sc));
				break;
			case 3:
				System.out.println("Enter Appointment id to delete: ");
				int id2 = sc.nextInt();
				AppointmentDAO.deleteAppointment(id2);
				break;
			case 4:
				List<Appointment> apps = AppointmentDAO.getAllAppointments();
	            System.out.println("Appointments in the database:");
	            for (Appointment app : apps) {
	                System.out.println("Patient ID: " + app.getPatientId() +
	                                   "\nDoctor ID: " + app.getDoctorId() +
	                                   "\nAppointment date: " + app.getAppointmentDate() +
	                                   "\nReason: " + app.getReason());
	                System.out.println("===========================================================");
	            }
	            System.out.println("===========================================================");
	            break;
			case 5:
				System.out.println("Exiting from the system!");
                sc.close();
                return;
            default:
                System.out.println("Enter valid choice (1-5): ");
                System.out.println("================================");
                System.out.println("");
			}
		}
	}
	
	public static Appointment enterDetailsAppt(Scanner sc) {
	    System.out.println("Enter your Updated details:");
	    sc.nextLine();
	    System.out.println("Enter patient ID:");
	    int p_id = sc.nextInt();
	    System.out.println("Enter doctor ID:");
	    int d_id = sc.nextInt();
	    System.out.println("Enter Appointment date (YYYY-MM-DD):");
	    String appDateStr = sc.next(); // Read the date as a string
	    Date app_date = Date.valueOf(appDateStr); // Convert the string to a Date object
	    System.out.println("Enter reason:");
	    sc.nextLine(); // Consume the remaining newline
	    String reason = sc.nextLine();
	    Appointment app = new Appointment(p_id, d_id, app_date, reason);
	    return app;
	}
	
	
    private static void manageStaff(Scanner sc) throws SQLException {
        while (true) {
            System.out.println("Manage Staff");
            System.out.println("Press 1 : To add new staff member");
            System.out.println("Press 2 : To update name of staff member");
            System.out.println("Press 3 : To delete a staff member");
            System.out.println("Press 4 : View all staff");
            System.out.println("Press 5 : Exit");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    StaffDAO.addStaff(enterDetailsStaff(sc));
                    break;
                case 2:
                	System.out.println("Enter Staff id to update: ");
    				int id = sc.nextInt();
    				StaffDAO.updateStaff(id, enterDetailsStaff(sc));
                    break;
                case 3:
                    System.out.println("Enter staff id to delete: ");
                    int id2 = sc.nextInt();
    				StaffDAO.deleteStaff(id2);
                    break;
                case 4:
                	List<Staff> staff = StaffDAO.getAllStaff();
    	            System.out.println("Staff in the database:");
    	            for (Staff s : staff) {
    	                System.out.println("Staff ID: " + s.getId() + 
    	                					"\nStaff name: " + s.getName() +
    	                                   "\nStaff role: " + s.getRole() +
    	                                   "\nStaff contact: " + s.getContactNumber());
    	                System.out.println("===========================================================");
    	            }
    	            System.out.println("===========================================================");
    	            break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    public static Staff enterDetailsStaff(Scanner sc) {
	    System.out.println("Enter your Updated details:");
	    sc.nextLine();
	    System.out.println("Enter name:");
	    String name = sc.next();
	    System.out.println("Enter role:");
	    String role = sc.next();
	    System.out.println("Enter contact number:");
	    String contact_number = sc.next();
	    Staff s = new Staff(name, role, contact_number);
	    return s;
	}
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("HMS MENU");
			System.out.println("Press 1: Manage patients");
			System.out.println("Press 2: Manage doctors");
			System.out.println("Press 3: Manage Appointments");
			System.out.println("Press 4: Manage Staff");
			System.out.println("Press 5: Exit");
			int choice = sc.nextInt();
				switch(choice) {
				case 1:
					managePatient(sc);
					break;
				case 2:
					manageDoctor(sc);
					break;
				case 3:
					manageAppt(sc);
					break;
				case 4:
					manageStaff(sc);
		            break;
				case 5:
					System.out.println("Exiting from the system!");
	                sc.close();
	                return;
	            default:
	                System.out.println("Enter valid choice (1-5): ");
	                System.out.println("================================");
	                System.out.println("");
				}
			}
	}
}