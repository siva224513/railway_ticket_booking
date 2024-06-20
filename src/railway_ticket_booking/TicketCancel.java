package railway_ticket_booking;

import java.util.HashMap;

public class TicketCancel extends TicketBooking {
	private static char preferenceTracker = '\0';
	private static int canceledSeatNumber = 0;

	private static HashMap<Integer, Character> seatNumberWithBerth = new HashMap<Integer, Character>();

	public static boolean findId(int id) {
		for (Passenger passenger : confirmedPassengersList) {
			if (passenger.getId() == id) {
				cancel(passenger);
				return true;
			}
		}
		for (Passenger passenger : upperBerthPassengersList) {
			if (passenger.getId() == id) {
				cancel(passenger);
				return true;
			}
		}
		for (Passenger passenger : lowerBerthPassengersList) {
			if (passenger.getId() == id) {
				cancel(passenger);
				return true;
			}
		}
		for (Passenger passenger : middleBerthPassengersList) {
			if (passenger.getId() == id) {
				cancel(passenger);
				return true;
			}
		}
		return false;
	}

	private static void cancel(Passenger passenger) {
		if (passenger.getTicketType() == "CONFIRMED") {
			preferenceTracker = passenger.getPreference();
			canceledSeatNumber = passenger.getSeatNumber();
			seatNumberWithBerth.put(canceledSeatNumber, preferenceTracker);
			removeFromAllList(passenger);
			moveRacToConfirm(racPassengers.poll());
			moveWaitingListToRac(waitingPassengers.poll());

		} else if (passenger.getTicketType() == "RAC") {
			racPassengers.remove(passenger);
			moveWaitingListToRac(waitingPassengers.poll());

		} else {
			waitingPassengers.remove(passenger);
		}

	}

	private static void removeFromAllList(Passenger passenger) {
		confirmedPassengersList.remove(passenger);
		upperBerthPassengersList.remove(passenger);
		lowerBerthPassengersList.remove(passenger);
		middleBerthPassengersList.remove(passenger);

	}

	private static void moveWaitingListToRac(Passenger passenger) {

		if (passenger != null) {
			passenger.setTicketType("RAC");
			racPassengers.add(passenger);
		}
	}

	private static void moveRacToConfirm(Passenger passenger) {

		if (passenger != null) {
			passenger.setSeatNumber(canceledSeatNumber);
			passenger.setPreference(preferenceTracker);
			passenger.setTicketType("CONFIRMED");
			if (preferenceTracker == 'U') {
				upperBerthPassengersList.add(passenger);
			} else if (preferenceTracker == 'L') {
				lowerBerthPassengersList.add(passenger);
			} else if (preferenceTracker == 'M') {
				middleBerthPassengersList.add(passenger);
			}

			confirmedPassengersList.add(passenger);
			seatNumberWithBerth.remove(canceledSeatNumber);
			preferenceTracker = '\0';
			canceledSeatNumber = 0;
		}
	}

}
