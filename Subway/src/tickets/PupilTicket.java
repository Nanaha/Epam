package tickets;

import java.sql.Date;

/**
 * @author Nanaha
 * The pupil's type of ticket which is by design the term one.
 */
public class PupilTicket extends TermTicket {
	public PupilTicket(Date startDate) {
		super(startDate, Terms.MONTHLY);
	}
	
	public PupilTicket() {
		super(Terms.MONTHLY);
	}
	
	public TicketTypes getType() {
		return TicketTypes.PUPIL;
	}
}
