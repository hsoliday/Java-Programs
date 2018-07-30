

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Program5 
{

	public static void main(String[] args) 
	{
		try{
		Scanner scan=new Scanner(new File(args[0]));
		LinkedList<Patient> patients =new LinkedList<Patient>();
		if(args.length<2)
		{
			throw new InvalidParameterException();
		}
		if(!scan.hasNextLine())
		{
			throw new InvalidFileException();
		}
		while(scan.hasNextLine())
		{
			Patient p=new Patient();
			String temp=scan.nextLine();
			String[] hold= new String[2];
			hold=parseNext(temp);
			p.firstName=hold[1];
			
			temp=hold[0].substring(0);
			hold=parseNext(temp);
			p.lastName=hold[1];
			
			temp=hold[0].substring(0);
			hold=parseNext(temp);
			p.age=Integer.parseInt(hold[1]);
			
			temp=hold[0].substring(0);
			hold=parseNext(temp);
			p.room=Integer.parseInt(hold[1]);
			
			p.set();			
			patients.add(p);
		}
		if(args[1].equalsIgnoreCase("last"))
		{
			Collections.sort(patients,new CompareLast());
		}
		else if(args[1].equalsIgnoreCase("First"))
		{
			Collections.sort(patients,new CompareFirst());
		}
		else if(args[1].equalsIgnoreCase("age"))
		{
			Collections.sort(patients,new CompareAge());
		}
		else if(args[1].equalsIgnoreCase("room"))
		{
			Collections.sort(patients,new CompareLast());
		}
		else
		{
			throw new InvalidSortException();
		}
		Patient[] arr = new Patient[patients.size()];
		arr=patients.toArray(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i].firstName+"\t"+arr[i].lastName+"\t"+arr[i].age+"\t"+arr[i].room);
		}
		}
		catch(InvalidSortException e)
		{
			
		}
		catch(InvalidFileException e)
		{
			
		}
		catch(InvalidParameterException e)
		{
			
		}
		catch(FileNotFoundException e)
		{
			
		}
	}
		

}
class CompareFirst implements Comparator<Patient>
{
	public int compare(Patient p, Patient q)
	{
		return p.firstName.toLowerCase().indexOf(0) -q.firstName.toLowerCase().indexOf(0);
		
	}
}
class CompareLast implements Comparator<Patient>
{
	public int compare(Patient p, Patient q)
	{
		return p.lastName.toLowerCase().indexOf(0) -q.lastName.toLowerCase().indexOf(0);
		
	}
}
class CompareRoomNum implements Comparator<Patient>
{
	public int compare(Patient p, Patient q)
	{
		return p.room-q.room;
	}
}
class CompareAge implements Comparator<Patient>
{
	public int compare(Patient p, Patient q)
	{
		return p.age-q.age;
		
	}
}
class Patient
{
	String firstName;
	String lastName;
	char fI;
	char lI;
	int age;
	int room;
	public void set()
	{
		fI=firstName.charAt(0);
		lI=lastName.charAt(0);
	}
}
class InvalidFileException extends Exception
{
}
class InvalidParameterException extends Exception
{
}
class InvalidSortException extends Exception
{
}