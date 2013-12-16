/**
 * 
 */
package passing;
import java.util.Date;
import tickets.Ticket;

/**
 * @author Nanaha
 * Item which holds information about a single pass try
 */
public class Pass {
	private Date date;
	private boolean success;
	private Ticket ticket;
	
	public Pass(Date date, Ticket ticket, boolean success) {
		this.date = date;
		this.success = success;
		this.ticket = ticket;
	}
	
	public Date getDate() {
		return date;
	}
	
	public boolean isSuccessful() {
		return success;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
}
