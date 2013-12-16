/**
 * 
 */
package passing;

/**
 * @author Nanaha
 * The turnstile which scans a ticket
 */
public class Turnstile {

	public boolean validate(int id) {
		return ControllerSystem.validate(id);
	}
}
