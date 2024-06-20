package railway_ticket_booking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TicketBooking {
	private static int berthLimit = 0;
	private static int racLimit = 1;
	private static int waitListLimit = 2;

	private static int upperBerthSeatNumber = 1;
	private static int middleBerthSeatNumber = 2;
	private static int lowerBerthSeatNumber = 3;

	static ArrayList<Passenger> confirmedPassengersList = new ArrayList<Passenger>();

	static ArrayList<Passenger> upperBerthPassengersList = new ArrayList<Passenger>();
	static ArrayList<Passenger> middleBerthPassengersList = new ArrayList<Passenger>();
	static ArrayList<Passenger> lowerBerthPassengersList = new ArrayList<Passenger>();

	static Queue<Passenger> racPassengers = new LinkedList<Passenger>();
	static Queue<Passenger> waitingPassengers = new LinkedList<Passenger>();

	public static void bookTicket(Passenger passenger) {

		if (upperBerthPassengersList.size() == berthLimit && middleBerthPassengersList.size() == berthLimit
				&& lowerBerthPassengersList.size() == berthLimit) {
			if (updateRacList(passenger)) {
				System.out.println("Add to RAC.. Your Ticket id is :" + passenger.getId());
			} else if (updateWaitList(passenger)) {
				System.out.println("Add to WaitingList.. Your Ticket id is :" + passenger.getId());
			} else {
				passenger.setId(passenger.getId() - 1);
				System.out.println(" --Tickets Are Not Available--");
			}

		} else if (checkAvailability(passenger)) {
			System.out.println("Booking confirmed.. Your Ticket id is" + passenger.getId());
			passenger.setTicketType("CONFIRMED");
			confirmedPassengersList.add(passenger);
		} else {
			System.out.println(passenger.getPreference() + "is not available");
			passenger.setId(passenger.getId() - 1);
			availableList();
		}
	}

	private static boolean updateWaitList(Passenger passenger) {

		if (waitingPassengers.size() < waitListLimit) {
			passenger.setTicketType("WAITING");
			waitingPassengers.add(passenger);
			return true;
		}
		return false;
	}

	private static boolean updateRacList(Passenger passenger) {

		if (racPassengers.size() < racLimit) {
			passenger.setTicketType("RAC");
			racPassengers.add(passenger);
			return true;
		}
		return false;
	}

	public static void availableList() {

		System.out.println("check-out No of seats available:");
		System.out.println("Upperberth available seats: " + (berthLimit - upperBerthPassengersList.size()));
		System.out.println("middleberth available seats: " + (berthLimit - middleBerthPassengersList.size()));
		System.out.println("lowerberth available seats: " + (berthLimit - lowerBerthPassengersList.size()));
	}

	private static boolean checkAvailability(Passenger passenger) {
		if (upperBerthPassengersList.size() < berthLimit && passenger.getPreference() == 'U') {
			passenger.setSeatNumber(upperBerthSeatNumber);
			upperBerthSeatNumber += 3;
			upperBerthPassengersList.add(passenger);
			return true;
		} else if (middleBerthPassengersList.size() < berthLimit && passenger.getPreference() == 'M') {
			passenger.setSeatNumber(middleBerthSeatNumber);
			middleBerthSeatNumber += 3;
			middleBerthPassengersList.add(passenger);
			return true;
		} else if (lowerBerthPassengersList.size() < berthLimit && passenger.getPreference() == 'L') {
			passenger.setSeatNumber(lowerBerthSeatNumber);
			lowerBerthSeatNumber += 3;
			lowerBerthPassengersList.add(passenger);
			return true;
		}

		return false;
	}

	public static void printBookedTickets() {
		System.out.println("-------------------------");
		for (Passenger p : confirmedPassengersList) {
			System.out.println(p.toString());
			System.out.println("-------------------------");

		}

	}

	public static void printRacList() {
		System.out.println("-------------------------");
		for (Passenger p : racPassengers) {
			System.out.println(p.toString());
			System.out.println("-------------------------");

		}

	}

	public static void printWaitingList() {
		System.out.println("-------------------------");
		for (Passenger p : waitingPassengers) {
			System.out.println(p.toString());
			System.out.println("-------------------------");

		}

	}

}
