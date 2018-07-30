
package hunterSolidayProgram1;

import java.util.LinkedList;
import java.util.Scanner;

public class HunterSolidayProgram1 
{

	public static void main(String[] args) 
	{
		LinkedList<String> list= new LinkedList<String>();
		Scanner myScan =  new Scanner(System.in);
		
		System.out.println("Program By Hunter Soliday\n\n");
		System.out.println("Please enter a name:");
			list.add(myScan.nextLine());
		
		System.out.println("Please enter the gender of above person(M/F):");
		
		
		if(myScan.nextLine().equalsIgnoreCase("F"))
			{
			list.add("She");
			}
		else
			{
			list.add("He"); //  the woe of not having a gender neutral pronoun
			}
		//This just puts he if the input is not f
		
		System.out.println("Please enter a Tech Startup:");
			list.add(myScan.nextLine()); //these tabs over really don't need to be here, but it makes it easier to count inputs
		System.out.println("Please enter a Software:");
			list.add(myScan.nextLine());
		System.out.println("Please enter a number");
			list.add(myScan.nextLine());// doesn't  actually read a number, just a string 
		System.out.println("Please enter a Tech message board:");
			list.add(myScan.nextLine());
		
		String[] str = new String[list.size()];// I wasn't sure how many entries I would get, so I just used a LinkedList because it can grow, unlike an array
		str=list.toArray(str);
		// I counted how many elements I had after the fact
		System.out.println(str[0]+" was an intern sysadmin at "+str[2]+". "+str[1]+" was told to reasearch "+str[3]+". "+str[0]+" struggled to learn said software for "+str[4]+" weeks, but then "+str[0]+ " was saved from an abundant lack of documentation by " +str[5]+".");
	}

}
