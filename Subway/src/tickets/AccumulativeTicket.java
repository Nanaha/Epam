package tickets;

/**
 * @author Nanaha
 *
 * The type of ticket with the amount of money on the account to buy tickets;
 */
public class AccumulativeTicket extends Ticket {
	
	private int sum; 
		
	public AccumulativeTicket(int sum) {
		this.sum = sum;
	}
	
	public void add(int sum) {
		this.sum += sum;
	}
	
	public int getAccount() {
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("type: " + getType());
		sb.append("id: " + getId());
		sb.append("account money: " + sum);
		return sb.toString();
	}
	
	public boolean validate() {
		boolean valid = sum >= COST_OF_TICKET;
		if (valid) {
			sum -= COST_OF_TICKET;
		}
		return valid;
	}
}
