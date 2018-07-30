//===============================================
// CS 1 : Program 2
// RELICS calculator
//
//Semester: Fall 2017
//
//Author: Hunter Soliday
//CRN: 60992
//CWID:A11684972
// Description:
// this just takes in the values for this equation it adds them to an array list and then multiply them together to get the answer
//==========================================================
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HunterSolidayProgram2 
{

	public static void main(String[] args) {
	   Scanner scan =new Scanner(System.in);
       ArrayList<Double> arrList = new ArrayList<Double>();
       System.out.println("RELICS calculator by Hunter Soliday");
      System.out.println(" Enter the following:");
      try{
      System.out.println("R: Average Rate of Milky Way star Formation in stars/year:");
      	arrList.add(new Double(Double.parseDouble(scan.nextLine())));
      System.out.println("E: Average number of planets per star:");
      	arrList.add(new Double(Double.parseDouble(scan.nextLine())));
      System.out.println("L:fraction of planets that develop life:");
      	arrList.add(new Double(Double.parseDouble(scan.nextLine())));
      System.out.println("I: fraction of life bearing planets where civilizations develop:");
      	arrList.add(new Double(Double.parseDouble(scan.nextLine())));
      System.out.println("C: fraction of civilizations that have detectable communications:");
      	arrList.add(new Double(Double.parseDouble(scan.nextLine())));
      System.out.println("S: length of time (in years) over which civilizations release signals:"); 
      	arrList.add(new Double(Double.parseDouble(scan.nextLine())));
      Double[] arr= new Double[arrList.size()];
      	arr =arrList.toArray(arr);
      }
      catch (InputMismatchException e)
		{
		System.out.println("Improper input dectected. Input must be decimal or integer value");
		}
      catch(NumberFormatException e){
    	  System.out.println("Improper input dectected. Input must be decimal or integer value");
      }
      	System.out.println("R * E * L * I * C * S = "+arr[0] +" * "+ arr[1]+" * " +arr[2]+" * "+arr[3] + " * " +arr[4]+" * "+arr[5]+"  = " + (arr[0]*arr[1]*arr[2]*arr[3]*arr[4]*arr[5]) +" detectable civilizations in the Milky Way galaxy");
	}

}
