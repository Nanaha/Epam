/**
 * 
 */
package tickets;

/**
 * @author Nanaha
 * All the possible types of tickets
 */
public enum TicketTypes {
	UNKNOWN("Unknown"),
	ACCUMULATIVE("Accumulative"),
	NUMBERED("Numbered"),
	TERM("Term"),
	STUDENT("Student"),
	PUPIL("Pupil");
	
	private String type;
	private TicketTypes(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}
}
