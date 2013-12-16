package passing;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Date;

import exceptions.CreationFailedException;

import tickets.*;

/**
 * @author Nanaha
 * System which controls the creation of tickets, validations and statistics count
 */
public class ControllerSystem {
	public static int ticketIdGenerator;
	public static int passIdGenerator;
	private static Map<Integer, Ticket> tickets = new HashMap<>();
	private static Map<Integer, Pass> pass = new HashMap<>();
	
	
	public static boolean validate(int id) {
		Ticket ticket =  ControllerSystem.findById(id);
		if (ticket == null) {
			return false;
		}
		
		boolean success = ticket.validate();
		pass.put(++passIdGenerator, new Pass(new Date(), ticket, success));
		return success;
	}
	
	public static List<Pass> getPassByType(TicketTypes type) {
		List<Pass> list = new ArrayList<>();
		
		Iterator<Entry<Integer, Pass>> it = pass.entrySet().iterator();
	    while (it.hasNext()) {
	    	Entry<Integer, Pass> entry = it.next();
	    	if (entry.getValue().getTicket().getType().equals(type)) {
	    		list.add(entry.getValue());
	    	}
	    }
	    return list;
	}
	
	public static List<Pass> getStatisticsByDate(Date startDate, Date endDate) {
		List<Pass> list = new ArrayList<>();
		
		Iterator<Entry<Integer, Pass>> it = pass.entrySet().iterator();
	    while (it.hasNext()) {
	    	Entry<Integer, Pass> entry = it.next();
	    	if (entry.getValue().getDate().after(startDate) && entry.getValue().getDate().before(endDate)) {
	    		list.add(entry.getValue());
	    	}
	    }
	    return list;
	}
	
	public static List<Pass> getStatistics(boolean success, TicketTypes type) {
		List<Pass> list = new ArrayList<>();
		
		Iterator<Entry<Integer, Pass>> it = pass.entrySet().iterator();
	    while (it.hasNext()) {
	    	Entry<Integer, Pass> entry = it.next();
	    	if (entry.getValue().isSuccessful() == success 
	    			&& entry.getValue().getTicket().getType().equals(type)) {
	    		list.add(entry.getValue());
	    	}
	    }
	    return list;
	}
	
	public static List<Pass> getStatistics(boolean success) {
		List<Pass> list = new ArrayList<>();
		
		Iterator<Entry<Integer, Pass>> it = pass.entrySet().iterator();
	    while (it.hasNext()) {
	    	Entry<Integer, Pass> entry = it.next();
	    	if (entry.getValue().isSuccessful() == success) {
	    		list.add(entry.getValue());
	    	}
	    }
	    return list;
	}
	
	public static Ticket create(TicketTypes type) throws CreationFailedException {
		Ticket ticket;
		switch(type) {
		case STUDENT:
			ticket = new StudentTicket();
			break;
		case PUPIL:
			ticket = new PupilTicket();
			break;
		default:
			throw new CreationFailedException("Invalid parameters for ticket type " + type.toString());
		}
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}
	
	public static Ticket create(TicketTypes type, Terms param) throws CreationFailedException {
		Ticket ticket;
		switch(type) {
		case TERM:
			ticket = new TermTicket(param);
			break;
		default:
			throw new CreationFailedException("Invalid parameters for ticket type " + type.toString());
		}
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}
	
	public static Ticket create(TicketTypes type, int param) throws CreationFailedException {
		Ticket ticket;
		switch(type) {
		
		case ACCUMULATIVE:
			ticket = new AccumulativeTicket(param);
			break;
		case NUMBERED:
			ticket = new NumberedTicket(param);
			break;
		default:
			throw new CreationFailedException("Invalid parameters for ticket type " + type.toString());
		}
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}
	
	public static Ticket findById(int id) {
		return tickets.get(id);
	}
	
	public static List<Ticket> getByType(TicketTypes type) {
		List<Ticket> list = new ArrayList<>();
		
		Iterator<Entry<Integer, Ticket>> it = tickets.entrySet().iterator();
	    while (it.hasNext()) {
	    	Entry<Integer, Ticket> entry = it.next();
	    	if (entry.getValue().getType().equals(type)) {
	    		list.add(entry.getValue());
	    	}
	    }
	    
	    return list;
	}
}
