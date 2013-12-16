/**
 * 
 */
package tickets;

import java.sql.Date;

/**
 * @author Nanaha
 * The student's type of ticket which is by default the term one
 */
public class StudentTicket extends TermTicket {
	public StudentTicket(Date startDate) {
		super(startDate, Terms.MONTHLY);
	}
	
	public StudentTicket() {
		super(Terms.MONTHLY);
	}
	
	public TicketTypes getType() {
		return TicketTypes.STUDENT;
	}
}
