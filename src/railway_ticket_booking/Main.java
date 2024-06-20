package railway_ticket_booking;

import java.sql.Savepoint;
import java.util.Scanner;

import javax.lang.model.util.SimpleAnnotationValueVisitor14;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println(
					"1.Booking Ticket\n2.Cancel Ticket\n3.Print Booked Tickets\n4.Print available Tickets\n5.Print RAC List\n6.Print Waiting List\n7.Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: {
				System.out.println("Welcome to ticket booking");
				System.out.println("Enter your name:");
				String name = scanner.nextLine();
				System.out.println("Enter your age:");
				int age = scanner.nextInt();
				System.out.println("Enter your gender(M/F/O):");
				char gender = scanner.next().charAt(0);
				System.out.println("Enter your berth preference (U/L/M):");
				char preference = scanner.next().charAt(0);

				Passenger passenger = new Passenger(name, age, gender, preference);
				TicketBooking.bookTicket(passenger);

				break;
			}
			case 2: {
                System.out.println("Enter your ticket id:");
                int id=scanner.nextInt();
                TicketCancel.findId(id);
				break;
			}
			case 3: {
				TicketBooking.printBookedTickets();
				break;
			}
			case 4: {
				TicketBooking.availableList();
				break;
			}
			case 5: {
				TicketBooking.printRacList();
				break;
			}
			case 6: {
				TicketBooking.printWaitingList();
				break;
			}
			case 7: {
				System.out.println("Thank you for visiting...!!!");
				exit = true;
				scanner.close();
				break;
			}
			}
			System.out.println();

		}
	}

}
