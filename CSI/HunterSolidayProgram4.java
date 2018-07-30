//===============================================
// CS 1 : Program 4
// Braille Printer
//
//Semester: Fall 2017
//
//Author: Hunter Soliday
//CRN: 60992
//
// Description:
// this takes input, passes it to a static method that uses a case statement to 
// append a set of arrays with the 3 respective rows of braille. Then the 
// printBraille function prints out the braille, six rows at a time
//==========================================================

package hunterSolidayProgram1;

import java.util.Scanner;

public class HunterSolidayProgram4 
{

	public static void main(String[] args)
	{
		System.out.println("Program 4 By Hunter Soliday\n\n");
		Scanner scan = new Scanner(System.in);
		printBraille(textToBraille(scan.nextLine()));// entire program
	}
	public static void printBraille(String[] str)
	{
		
		int fullLines;
		int partialNum;
		fullLines=str[0].length()/18;
		partialNum=str[0].length()%18;
		// find the number of lines that can fully be printed( a line is 18 characters, or six braille characters in this program)
		if(fullLines==0&&partialNum==0)
		{
			System.out.println("no submitted input");
			return;
		}
		String[] partial = new String[4]; // this cuts off the extra strings that do not constitute a full 6-braille-character Line
		
		partial[0]=str[0].substring(str[0].length()-partialNum);
		str[0] =str[0].substring(0,str[0].length()-partialNum);
		partial[1]=str[1].substring(str[1].length()-partialNum);
		str[1] =str[1].substring(0,str[1].length()-partialNum);
		partial[2]=str[2].substring(str[2].length()-partialNum);
		str[2] =str[2].substring(0,str[2].length()-partialNum);
		partial[3]=str[3].substring(str[3].length()-partialNum);
		str[3] =str[3].substring(0,str[3].length()-partialNum);
		
		// this prints out all the full 6-braille-character lines
		for(int i=0;i<fullLines;i++)
		{
			System.out.println(str[3].substring(0,18));
			System.out.println(str[0].substring(0,18));
			System.out.println(str[1].substring(0,18));
			System.out.println(str[2].substring(0,18));
			System.out.println("");
			str[3]=str[3].substring(18);
			str[0]=str[0].substring(18);
			str[1]=str[1].substring(18);
			str[2]=str[2].substring(18);
			i++;
		}
		// if there is extra, print it
		if(partialNum>0)
		{
			System.out.println(partial[3]);
			System.out.println(partial[0]);
			System.out.println(partial[1]);
			System.out.println(partial[2]);
		}
		
	}
	public static String[] textToBraille(String str)
	{
		// this works by adding the 3 respective lines of braile to 3 different strings, and then returns all the strings in an array of 3 strings
		String[] output={"","","",""};
		str=str.toLowerCase();// not dealing with mixed case letters, so it is all one case, lower case
		char [] charArr = str.toCharArray();// so this is easier to deal with(could use charAt, but I don't want to)
		for(int i =0;i<charArr.length;i++)// Iterates through whole array, adding to the three strings the braille characters
		{
			output[3]+=charArr[i]+"  ";
			switch(charArr[i])
			{
				case'1':
				case'a':
					output[0]+=". |";// decided to do this because it is easier to see the braille in code
					output[1]+="  |";
					output[2]+="  |";
					break;
				case'2':
				case'b':
					output[0]+=". |";
					output[1]+=". |";
					output[2]+="  |";
					break;
				case'3':
				case'c':
					output[0]+="..|";
					output[1]+="  |";
					output[2]+="  |";
					break;
				case'4':
				case'd':
					output[0]+="..|";
					output[1]+=" .|";
					output[2]+="  |";
					break;
				case'5':
				case'e':
					output[0]+=". |";
					output[1]+=" .|";
					output[2]+="  |";
					break;
				case'6':
				case'f':
					output[0]+="..|";
					output[1]+=". |";
					output[2]+="  |";
					break;
				case'7':
				case'g':
					output[0]+="..|";
					output[1]+="..|";
					output[2]+="  |";
					break;
				case'8':
				case'h':
					output[0]+=". |";
					output[1]+="..|";
					output[2]+="  |";
					break;
				case'9':
				case'i':
					output[0]+=" .|";
					output[1]+=". |";
					output[2]+="  |";
					break;
				case'0':
				case'j':
					output[0]+=" .|";
					output[1]+="..|";
					output[2]+="  |";
					break;
				case'k':
					output[0]+=". |";
					output[1]+="  |";
					output[2]+=". |";
					break;
				case'l':
					output[0]+=". |";
					output[1]+=". |";
					output[2]+=". |";
					break;
				case'm':
					output[0]+="..|";
					output[1]+="  |";
					output[2]+=". |";
					break;
				case'n':
					output[0]+="..|";
					output[1]+=" .|";
					output[2]+=". |";
					break;
				case'o':
					output[0]+=". |";
					output[1]+=" .|";
					output[2]+=". |";
					break;
				case'p':
					output[0]+="..|";
					output[1]+=". |";
					output[2]+=". |";
					break;
				case'q':
					output[0]+="..|";
					output[1]+="..|";
					output[2]+=". |";
					break;
				case'r':
					output[0]+=". |";
					output[1]+="..|";
					output[2]+=". |";
					break;
				case's':
					output[0]+=" .|";
					output[1]+=". |";
					output[2]+=". |";
					break;
				case't':
					output[0]+=" .|";
					output[1]+="..|";
					output[2]+=". |";
					break;
				case'u':
					output[0]+=". |";
					output[1]+="  |";
					output[2]+="..|";
					break;
				case'v':
					output[0]+=". |";
					output[1]+=". |";
					output[2]+="..|";
					break;
				case'w':
					output[0]+=" .|";
					output[1]+="..|";
					output[2]+=" .|";
					break;
				case'x':
					output[0]+="..|";
					output[1]+="  |";
					output[2]+="..|";
					break;
				case'y':
					output[0]+="..|";
					output[1]+=" .|";
					output[2]+="..|";
					break;
				case'z':
					output[0]+=". |";
					output[1]+=" .|";
					output[2]+="..|";
					break;
				
				case ' ':
					output[0]+="  |";
					output[1]+="  |";
					output[2]+="  |";
					break;
				}	
		}
		return output;
	}

}
