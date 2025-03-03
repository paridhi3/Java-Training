package MovieTicketBooking;

import java.util.Scanner;

public class Menu {
	
	public static void adminMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("What would you like to do today?");
			System.out.println("Press 1: Create Database tables");
			System.out.println("Press 2: Insert new movies");
			System.out.println("Press 3: Insert shows");
			System.out.println("Press 4: Exit");
			System.out.println("--------------------------------------------------------------------");
			
			int ch = sc.nextInt();
			
			switch (ch) {
            case 1:
            	CreateDatabseTables.createTables();;
                break;
            case 2:
            	InsertData.insertMovies();
                break;
            case 3:
            	InsertData.insertShows();
                break;
            case 4:
                System.out.println("Thank you, exiting from system");
                sc.close();
                return;
            default:
            	System.out.println("Invalid choice");

            }
			
			
		} // end of while loop
	} //
	
	
	public static void userMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("What would you like to do today?");
			System.out.println("Press 1: Display all avaliable movies and shows");
			System.out.println("Press 2: Book ticket");
			System.out.println("Press 3: View your ticket confirmation");
			System.out.println("Press 4: Cancel your ticket");
			System.out.println("Press 5: Exit");
			System.out.println("--------------------------------------------------------------------");
			
			int ch = sc.nextInt();
			
			switch (ch) {
            case 1:
            	ShowAvailableMovies.displayAll();
                break;
            case 2:
            	TicketBooking.bookTicket();
                break;
            case 3:
            	bookingConfirmation.confirmBooking();
                break;
            case 4:
            	TicketCancellation.cancelTicket();
                break;
            case 5:
                System.out.println("Thank you, exiting from system");
                sc.close();
                return;
            default:
            	System.out.println("Invalid choice");

            }
			
		} // end of while loop
	}
	
	
	
	
}
