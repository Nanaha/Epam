package tickets;

import java.util.Date;
import java.util.Calendar;

/**
 * @author Nanaha
 * The ticket with the expiration date specified;
 */
public class TermTicket extends Ticket {
	
	private Date startDate;
	private Date expirationDate;
	
	public boolean validate() {
		return (new Date().before(expirationDate));
	}
	
	public TermTicket(Terms term) {
		startDate = new Date();
		countExpirationDate(term);
	}
	
	public TermTicket(Date startDate, Terms term) {
		this.startDate = startDate;
		countExpirationDate(term);
		
	}
	
	private void countExpirationDate(Terms term) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_MONTH, term.days());
		expirationDate = calendar.getTime();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("type: " + getType());
		sb.append("id: " + getId());
		sb.append("start date: " + startDate);
		sb.append("expiration date: " + expirationDate);
		return sb.toString();
	}
	
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public TicketTypes getType() {
		return TicketTypes.TERM;
	}
}
