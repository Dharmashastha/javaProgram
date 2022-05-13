package railway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RailwayOperation {

	Map<String, List<Berth>> berthMap = new HashMap<>();
	Map<Long, List<Passenger>> passengerMap = new HashMap<>();
	Map<Long, List<Berth>> bookedMap = new HashMap<>();
	List<Passenger> waitingList = new ArrayList<>();
	private long ticketNumber = 10000;

	public long newTicketNumber() {
		return ++ticketNumber;
	}
	
	public void splitBerth(int split,String berthType)
	{
		List<Berth> berthList = new ArrayList<>();
		for (int i = 1; i <= split; i++) {
			Berth berthCall = new Berth();
			berthCall.setBerthType(berthType);
			berthCall.setSeats(i);
			berthList.add(berthCall);
		}
		berthMap.put(berthType, berthList);
	}
	
	public void allocateBerth(int slot, int racSlot) {
		int split = slot / 3;
		String berthType = null;
		
		for(int i = 1; i <= 4; i++)
		{
			switch(i)
			{
				case 1:
				{
					berthType = "Upper";
					splitBerth(split, berthType);
					break;
				}
				case 2:
				{
					berthType = "Middle";
					splitBerth(split, berthType);
					break;
				}
				case 3:
				{
					berthType = "Lower";
					splitBerth(split, berthType);
					break;
				}
				case 4:
				{
					berthType = "RAC";
					splitBerth(racSlot, berthType);
					break;
				}
			}
		}		
		
//		for (int i = 1; i <= split; i++) {
//			Berth berthCall = new Berth();
//			berthType = "Upper";
//			berthCall.setBerthType(berthType);
//			berthCall.setSeats(i);
//			upperList.add(berthCall);
//		}
//		berthMap.put(berthType, upperList);
//
//		for (int i = 1; i <= split; i++) {
//			Berth berthCall = new Berth();
//			berthType = "Middle";
//			berthCall.setBerthType(berthType);
//			berthCall.setSeats(i);
//			middleList.add(berthCall);
//		}
//		berthMap.put(berthType, middleList);
//
//		for (int i = 1; i <= split; i++) {
//			Berth berthCall = new Berth();
//			berthType = "Lower";
//			berthCall.setBerthType(berthType);
//			berthCall.setSeats(i);
//			lowerList.add(berthCall);
//		}
//		berthMap.put(berthType, lowerList);
//
//		for (int i = 1; i <= racSlot; i++) {
//			Berth berthCall = new Berth();
//			berthType = "RAC";
//			berthCall.setBerthType(berthType);
//			berthCall.setSeats(i);
//			racList.add(berthCall);
//		}
//		berthMap.put(berthType, racList);
	}

	public void nullCheckPassenger(List<Passenger> passList) throws Exception {
		if (passList == null) {
			throw new Exception("PassengerDetails Empty");
		}
	}
	
	public void nullCheckBerth(List<Berth> berthList) throws Exception {
		if (berthList == null) {
			throw new Exception("BerthDetails Empty");
		}
	}

	public void addPassengerDetails(long ticketNumber, List<Passenger> passList) throws Exception {
		nullCheckPassenger(passList);
		passengerMap.put(ticketNumber, passList);
	}
	
	public boolean checkEmpty(String berthType,List<Berth> list) throws Exception
	{
		nullCheckBerth(list);
		list = berthMap.get(berthType);
		return list.isEmpty();
	}
	
	public String checkerBerth(List<Berth> list) throws Exception
	{
		nullCheckBerth(list);
		String berthType = null;
		boolean flag = true;
		for(int i = 1; i <= 4; i++)
		{	
		switch(i)
		{
			case 1:
			{
				berthType = "Upper";
				flag = checkEmpty(berthType,list);
				break;
			}
			case 2:
			{
				berthType = "Middle";
				flag = checkEmpty(berthType,list);
				break;
			}
			case 3:
			{
				berthType = "Lower";
				flag = checkEmpty(berthType,list);
				break;
			}
			case 4:
			{
				berthType = "RAC";
				flag = checkEmpty(berthType,list);
				break;
			}
		}
		if(!flag)
		{
			break;
		}
		berthType = null;
		}
	return berthType;	
	}
	
	public void checkerWaitingList(int waitSize) throws Exception
	{
		if(waitingList.size() == waitSize)
		{
			throw new Exception("No Tickets Available");
		}
	}
	
	
	public List<Berth> addBooking(List<Passenger> passList, List<Berth> newList,int waitSize) throws Exception {
			List<Berth> berthList = new ArrayList<>();
			boolean flag = true;
			String berthType = null;
			int size = passList.size();
			for(int i = 0; i < size; i++)
			{
				Passenger passCall = passList.get(i);
				flag = checkEmpty(passCall.getBerthType(), berthList);
				berthList = berthMap.get(passCall.getBerthType());
				if(flag)
				{
					berthType = checkerBerth(berthList);
					berthList = berthMap.get(berthType);
				}
				if(!flag || berthType != null)
				{
					Berth berthCall = berthList.remove(0);
					passCall.setBerthType(berthCall.getBerthType());
					passCall.setSeats(berthCall.getSeats());
					passCall.setTicketStatus("Confirmed");
					newList.add(berthCall);
				}
				else
				{
					checkerWaitingList(waitSize);
					passCall.setTicketStatus("Waiting-List");
					waitingList.add(passCall);
				}				
			}
			
		
		
		
//		for (int i = 0; i < passList.size(); i++) {
//			Passenger passCall = passList.get(i);
//			String berthType = passCall.getBerthType();
//			List<Berth> berthList = berthMap.get(berthType);
//
//			if (berthList.size() != 0) {
//				Berth berthCall = berthList.remove(0);
//				passCall.setBerthType(berthCall.getBerthType());
//				passCall.setSeats(berthCall.getSeats());
//				passCall.setTicketStatus("Confirmed");
//				newList.add(berthCall);
//			} else {
//				berthList = berthMap.get("Upper");
//				if (berthList.size() != 0) {
//					Berth berthCall = berthList.remove(0);
//					passCall.setBerthType(berthCall.getBerthType());
//					passCall.setSeats(berthCall.getSeats());
//					passCall.setTicketStatus("Confirmed");
//					newList.add(berthCall);
//				} else {
//					berthList = berthMap.get("Lower");
//					if (berthList.size() != 0) {
//						Berth berthCall = berthList.remove(0);
//						passCall.setBerthType(berthCall.getBerthType());
//						passCall.setSeats(berthCall.getSeats());
//						passCall.setTicketStatus("Confirmed");
//						newList.add(berthCall);
//					} else {
//						berthList = berthMap.get("RAC");
//						if (berthList.size() != 0) {
//							Berth berthCall = berthList.remove(0);
//							passCall.setBerthType(berthCall.getBerthType());
//							passCall.setSeats(berthCall.getSeats());
//							passCall.setTicketStatus("Confirmed");
//							newList.add(berthCall);
//						} else {
//							passCall.setTicketStatus("Waiting-List");
//							waitingList.add(passCall);
//						}
//					}
//				}
//			}
//		}
		return newList;
	}

	public void bookingTicket(long ticketNumber,int waitSize) throws Exception {
		List<Passenger> passList = passengerMap.get(ticketNumber);
		List<Berth> newList = new ArrayList<>();
		bookedMap.put(ticketNumber, addBooking(passList, newList,waitSize));
	}
	
	public void cancelTicket(long ticketNumber)
	{
		List<Berth> berthList = bookedMap.remove(ticketNumber);
		int size = berthList.size();
		for(int i = 0; i < size; i++)
		{
			//Berth berthCall = berthList.get(i);
			
		}
	}
	
	
	
	
	public int bookedTickets(long ticketNumber)
	{
		List<Berth> berthList = bookedMap.get(ticketNumber);
		return berthList.size();
	}
	
	public String showPassengerDetails(long ticketNumber)
	{
		List<Passenger> passList = passengerMap.get(ticketNumber);
		int size = passList.size();
		String saved = "";
		
		for(int i = 0; i < size; i++)
		{
			Passenger passCall = passList.get(i);
			saved += passCall + "\n\n";
		}
	return saved;	
	}
	
	public String availableTickets()
	{
		String saved = "";
		for(String berthType:berthMap.keySet())
		{
			saved += berthType +" Berth Available Tickets is " + berthMap.get(berthType).size()+"\n\n";
		}
	return saved;	
	}
}
