package tickets;

/**
 * @author Nanaha
 *
 * The type of ticket with the definite amount of travels pre-bought;
 */
public class NumberedTicket extends Ticket {

	private int amount;
	
	public NumberedTicket(int amount) {
		this.amount = amount;
	}
	
	public boolean validate() {
		boolean valid = amount > 0;
		if (valid) {
			amount--;
		}
		return valid;
	}
	
	@Override
	public int getNumberOfTravels() {
		return amount;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("type: " + getType());
		sb.append("id: " + getId());
		sb.append("number of travels: " + amount);
		return sb.toString();
	}
	
	public TicketTypes getType() {
		return TicketTypes.NUMBERED;
	}
	
}
