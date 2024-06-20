package railway_ticket_booking;

public class Passenger {
	private static int idProvider = 0;
	private int id;
	private String name;
	private int age;
	private char gender;
	private char preference;
	private int seatNumber;
	private String ticketType;

	public Passenger(String name, int age, char gender, char preference) {
		this.id = ++idProvider;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.preference = preference;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getPreference() {
		return preference;
	}

	public void setPreference(char preference) {
		this.preference = preference;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	@Override
	public String toString() {

		return "Passenger Details:" + "\nTicket id: " + id + "\nName: " + name + "\nAge: " + age + "\nGender: " + gender
				+ "\nSeatNumber: " + seatNumber + "\nConfirmedBerth: " + preference;
	}
}
