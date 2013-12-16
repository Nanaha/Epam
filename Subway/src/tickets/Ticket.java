/**
 * 
 */
package tickets;
import java.util.Date;
import passing.ControllerSystem;

/**
 * @author Nanaha
 *
 * An abstract class which holds dummy methods in order to avoid implementing them in
 * types of tickets that do no need them.
 */
public abstract class Ticket {
	
	public final static int COST_OF_TICKET = 2;
	private int id;
	
	public Ticket() {
		id = ++ControllerSystem.ticketIdGenerator;
	}
	
	public boolean validate() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getExpirationDate() {
		return null;
	}
	
	public TicketTypes getType() {
		return TicketTypes.UNKNOWN;
	}
	
	int getNumberOfTravels() {
		return -1;
	}
	int getAccount() {
		return -1;
	}
}
