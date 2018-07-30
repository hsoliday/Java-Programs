package hunterSolidayProgram1;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HunterSolidayProgram3 {

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();// prefer using this over printf
		String str;
		Object[] hold = new Object[4]; // I decided this was a fun way to go about this 
		double rate;
		Scanner scan =new Scanner(System.in);
		System.out.println("Customer Name:");
		hold[0] = scan.nextLine();
		System.out.println("Customer member level:");
		// sets the rate(but in percent) and type in an integer
		while(true)
		{
			str=scan.nextLine();
			if(str.equalsIgnoreCase("Despicable"))
			{
				rate=0.8;
				hold[1]= new Integer(1);
				break;
			}
			else if(str.equalsIgnoreCase("Horrible"))
			{
				rate=2.0;
				hold[1]= new Integer(2);
				break;
			}
			else if(str.equalsIgnoreCase("NiceGuy"))
			{
				rate=3.1;
				hold[1]= new Integer(3);
				break;
			}
			else
			{
				//Preemptively requires the input to be proper
				System.out.println("Improper input dectected.Input must be one of: Despicable, Horrible, Niceguy");
				System.out.println("Customer member level:");
			}
		}
		System.out.println("Current Balance:");
		while(true)
		{
			try
			{
				hold[2] = new Double(scan.nextDouble());
				if(((Double)hold[2])<0)
				{
					// a bit of humor for a negative balance 
					System.out.println("Note: negative input detected. we are not in the\n"
							+ "business of giving away cash, get this resolved AS SOON AS POSSIBLE");
				}
				break;
		}
			catch (InputMismatchException e)
			{
			//requires proper input again
			System.out.println("Improper input dectected. Input must be decimal or integer value");
			scan.next();
			//increments scanner to clear the InputMismatchException
			}
		}
		System.out.println("Was the payment late(yes/no):");
		while(true)
		{
			//takes input so that it plays well with or statement
			str=scan.nextLine();
			if(str.equalsIgnoreCase("yes")||str.equalsIgnoreCase("y"))
			{
			hold[3]=new Boolean(true);
			break;
			}
			else if(str.equalsIgnoreCase("no")||str.equalsIgnoreCase("n")){
			hold[3]=new Boolean(false);
			break;
			}
		}
		// makes the temporary string into the type of customer
		System.out.println("Bill for "+hold[1].toString()+" customer: "+hold[0].toString());
		System.out.println("Card Balance: "+(Double)hold[2]);
		System.out.print("Minimum Payment to principle(4.0% of principle): ");
		System.out.println(formatter.format(((Double)hold[2])*0.04));
		System.out.print("Interest for ");
		double penaltyFee=0.0;
		// if there is a late fee
		if((Boolean)hold[3])
		{
			System.out.print("late");	
			double additive=0.0;
			//additive is the cnge 
			
			{
				if( hold[1].toString().equalsIgnoreCase("despicable"))
				{
					additive = 1.0;
				}
				else if(hold[1].toString().equalsIgnoreCase("horrible"))
				{
					additive = 1.1;
					penaltyFee=10;
				}
				else
				{
					additive = 1.2;
					penaltyFee=20;
				}
				System.out.print("payment (");
				rate+=additive;
				System.out.print(rate +"% of the principle): "+formatter.format((Double) hold[2]*rate*0.01)+"\n");
				System.out.println("late fee:"+formatter.format(penaltyFee));
				
			}
		}
		else
		{
			System.out.println("on-time payment:("+rate+"% of principle):"+formatter.format((((Double)hold[2]*(0.01*rate+0.04)+penaltyFee))));	
		}
			System.out.println("minimum total payment(payment, interest, and fees):"+formatter.format((((Double)hold[2]*(0.01*rate+0.04)+penaltyFee))));
			System.out.print("Percent to principle:"+String.format("%1$.1f",100*((((Double)hold[2]*(0.04)/((Double)hold[2]*(0.01*rate+0.04)+penaltyFee))))));
			System.out.println("%");
			System.out.println("percent to interest and fees:"+String.format("%1$.1f",100-(100*((((Double)hold[2]*(0.04)/((Double)hold[2]*(0.01*rate+0.04)+penaltyFee)))))));
	}

}
