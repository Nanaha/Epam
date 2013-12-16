/**
 * An enum which holds possible terms for term tickets.
 */
package tickets;

/**
 * @author Nanaha
 * As term tickets can be only of 2 types: for 10 days of for the month,
 * the possible types are gathered in this enum;
 */
public enum Terms {
	TENDAY (10),
	MONTHLY (31);
	
	private final int days;
	
	private Terms(int days) {
		this.days = days;
	}
	
	public int days() {
		return days;
	}
}
