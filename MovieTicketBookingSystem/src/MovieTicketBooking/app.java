package MovieTicketBooking;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to PVR INOX");
		System.out.println("Press 1 to REGISTER, 2 to LOGIN.");
		
		int res = sc.nextInt();
		
		if(res==1)
		{
			UserRegistration.register();
			return;
		}
		else if(res==2) {
			UserLogin.login();
			return;
		}
		else {
			System.out.println("Invalid choice");
			return;
		}
		
	} // end of main
	
	
} // end of class