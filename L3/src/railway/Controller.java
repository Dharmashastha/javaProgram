package railway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {
	
	RailwayOperation railCall = new RailwayOperation();	
	Scanner input = new Scanner(System.in);

public String getValueGender(int choice)
{
	String saved = null;
	switch(choice)
	{
		case 1:
		{
			saved = "Male";
			break;
		}
		case 2:
		{
			saved = "Female";
			break;
		}
		case 3:
		{
			saved = "Transgender";
			break;
		}
		default:
		{
			System.out.println("Please Enter Valid Choice");
			System.out.println("1.Male\n2.Female\n3.Transgender");
			getValueGender(input.nextInt());
			break;
		}
	}
return saved;	
}
	
public String getValueBerthType(int choice)
{
	String saved = null;
	switch(choice)
	{
		case 1:
		{
			saved = "Upper";
			break;
		}
		case 2:
		{
			saved = "Middle";
			break;
		}
		case 3:
		{
			saved = "Lower";
			break;
		}
		default:
		{
			System.out.println("Please Enter Valid Choice");
			System.out.println("1.Upper\n2.Middle\n3.Lower");
			getValueBerthType(input.nextInt());
			break;
		}
	}
return saved;	
}

public void checkBerthType(Passenger passCall)
{
	if(passCall.getAge() >= 60 || passCall.getGender().equals("Female"))
	{
		passCall.setBerthType("Lower");
	}
	else
	{
		System.out.println("Please Enter Your Choice");
		System.out.println("1.Upper\n2.Middle\n3.Lower");
		passCall.setBerthType(getValueBerthType(input.nextInt()));
	}
}
	
public void bookingTicket(int waitSize) throws Exception
{
	List<Passenger> passList = new ArrayList<>();
	System.out.println("How Many Tickets You Want");
	long ticketNumber = 0;
	int length = input.nextInt();
	if(length <= 6)
	{
		ticketNumber = railCall.newTicketNumber();
		for(int i = 0; i < length; i++)
		{
			Passenger passCall = new Passenger();
			System.out.println("Please Enter Your Name");
			input.nextLine();
			passCall.setName(input.nextLine());
			System.out.println("Please Enter Your Age");
			passCall.setAge(input.nextInt());
			System.out.println("Please Enter Your Choice");
			System.out.println("1.Male\n2.Female\n3.Transgender");
			passCall.setGender(getValueGender(input.nextInt()));
			checkBerthType(passCall);
			if(passCall.getAge() > 5)
			{
				passCall.setTicketNumber(ticketNumber);
			}
			passList.add(passCall);
		}
	}
	else
	{
		throw new Exception("Maximum Number Of Passenger 6 Only");
	}
	railCall.addPassengerDetails(ticketNumber, passList);
	railCall.bookingTicket(ticketNumber,waitSize);
	System.out.println("Your TicketNumber "+ ticketNumber);
}

public void getBookedTicket()
{
	System.out.println("Enter Your TicketNumber");
	long ticketNumber = input.nextLong();
	System.out.println("Ticket Number Of Berth "+ railCall.bookedTickets(ticketNumber));
	System.out.println("Number of PassengerDetails");
	System.out.println(railCall.showPassengerDetails(ticketNumber));
}

	
	public static void main(String[] args) {
	
		
		Controller conCall = new Controller();
		boolean flag = false;
		
		System.out.println("Please Enter Total Berth");
		int berth = conCall.input.nextInt();
		System.out.println("Please Enter RAC Berth");
		int rac = conCall.input.nextInt();
		System.out.println("Please Enter Waiting-List Size");
		int waitSize = conCall.input.nextInt();
		conCall.railCall.allocateBerth(berth, rac);
		
		while(!flag)
		{
			
			System.out.println("Please Enter Your Choice");
			System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.Booked Ticket\n4.Available Ticket\n5.Exit");
			int choice = conCall.input.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					try {
						conCall.bookingTicket(waitSize);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						//e.printStackTrace();
					}
					break;
				}
				case 2:
				{
					break;
				}
				case 3:
				{
					try {
					conCall.getBookedTicket();
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					break;
				}
				case 4:
				{
					System.out.println(conCall.railCall.availableTickets());
					break;
				}
				case 5:
				{
					flag = true;
					break;
				}
				default:
				{
					System.out.println("Enter the Valid Number");
					break;
				}
			}
		}
	conCall.input.close();	
	}
}
