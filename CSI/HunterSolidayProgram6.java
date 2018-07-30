package hunterSolidayProgram1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class HunterSolidayProgram6
{
	LinkedList<Type> subL;
	public static LinkedList<Type> l;
	public static Stack<String> stack;
	public static void main(String[] args) 
	{
		
		l=new LinkedList<Type>();
		stack = new Stack<String>();
		Scanner scan= new Scanner(System.in);
		System.out.println("Postfix calculator by Hunter Soliday:");
		System.out.print(">");
		while(true)
		{
			stack.clear();
			try
			{
				String tmp=scan.nextLine();
				tmp+=' ';
				if(tmp.equalsIgnoreCase("quit "))
				{
					break;
				}
				else if(tmp.equalsIgnoreCase("var "))
				{
					System.out.println(var());
				}
				else if(tmp.equalsIgnoreCase("clear "))
				{
					clear();
				}
				else if(tmp.equalsIgnoreCase("about "))
				{
					System.out.println("Postfix calculator by Hunter Soliday:");
					System.out.println("To solve a postfix expresssion just type it");
					System.out.println("( acceptable operators are + - *  / sqrt sin cos tan)");
					System.out.println("to save a variable:<Variable> = <expression>"); 	
				}
				else if(parseLine(tmp).length>1)
				{
					String[]  arr= parseLine(tmp);
					if(arr[1].equals("="))
					{
						String[] g= new String[arr.length-2]; 
						for(int i=2;i<arr.length;i++)
						{
							g[i-2]=arr[i];
						}
						Type t= new Type();
						t.data=operate(g);
						t.name=arr[0];
						if(!containsType(t))
						{
							l.add(t);
						}
						else
						{
							l.get(typeLocation(t)).data=t.data;
						}
						System.out.println(operate(g));
					}
					else
					{
						System.out.println(operate(arr));
					}
			}
			else
			{
				System.out.println(String.valueOf(storedValue(tmp.trim())));
			}
				System.out.print(">");
			}
			catch(UnknownVariableException e)
			{
				
				System.out.println("Sorry, I do not recognize that variable");
				System.out.print(">");
			}
			catch(CountException e)
			{
				System.out.println("Invalid number of operators");
				System.out.print(">");
			}
		}
	}
	public static double storedValue(String s) throws UnknownVariableException
	{
		try
		{
			return Double.parseDouble(s.trim());	
		}
		catch(NumberFormatException e)
		{
			for(Type t:l)
		{
			if(t.name.trim().equals(s.trim()))
			{
				return t.data;	
			}
		}
			throw new UnknownVariableException();
		}
	}
	public static double plus(double i,double j)
	{
		return i+j; 	
	}
	public static double operate(String[] str) throws CountException, UnknownVariableException
	{
		for(int i=0;i<str.length;i++)
	    {
			if(isOP(str[i])==0)
			{
				stack.push(String.valueOf(storedValue(str[i])));
			}
			else if(isOP(str[i])==1 && stack.size()>1)
			{
				stack.push(new Double(plus(storedValue(stack.pop()),storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==2 && stack.size()>1)
			{
				stack.push(new Double(minus(storedValue(stack.pop()),storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==3 && stack.size()>1)
			{
				stack.push(new Double(multiply(storedValue(stack.pop()),storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==4 && stack.size()>1)
			{
				stack.push(new Double(divide(storedValue(stack.pop()),storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==5)
			{
				stack.push(new Double(sqrt(storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==6)
			{
				stack.push(new Double(sin(storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==7)
			{
				stack.push(new Double(cos(storedValue(stack.pop()))).toString());
			}
			else if(isOP(str[i])==8)
			{
				stack.push(new Double(tan(storedValue(stack.pop()))).toString());
			}
			else
			{
				throw new CountException();
			}
		}
		if(stack.size()==1)
		{
			return Double.parseDouble(stack.pop());
		}
		else
		{
			throw new CountException();
		}
	}
	public static int typeLocation(Type t)
	{
		if(!containsType(t))
		{
			return -1;
		}
		else
		{
			for(int i=0;i<l.size();i++)
			{
				if(l.get(i).name.equals(t.name))
				{
					return i;
				}
			}
		}
		return -1;
		
	}
	public static boolean containsType(Type t)
	{
		for(Type g: l)
		{
			if(g.name.equals(t.name))
			{
				return true;
			}
		}
		return false;
	}
	public static int isOP(String str)
	{
		if(str.equalsIgnoreCase("+"))
		{
			return 1;
		}
		else if(str.equalsIgnoreCase("-"))
		{
			return 2;
		}
		else if(str.equalsIgnoreCase("*"))
		{
			return 3;
		}
		else if(str.equalsIgnoreCase("/"))
		{
			return 4;
		}
		else if(str.equalsIgnoreCase("sqrt"))
		{
			return 5;
		}
		else if(str.equalsIgnoreCase("sin"))
		{
			return 6;
		}
		else if(str.equalsIgnoreCase("cos"))
		{
			return 7;
		}
		else if(str.equalsIgnoreCase("tan"))
		{
			return 8;
		}
		else
		{
			return 0;
		}
	}
	public static double minus(double i,double j)
	{
		return j-i; 	
	}
	public static double multiply(double i,double j)
	{
		return i*j; 	
	}
	public static double divide(double i,double j)
	{
		return j/i; 	
	}
	public static double sqrt(double i)
	{
		return Math.sqrt(i); 	
	}
	public static double sin(double i)
	{
		return Math.sin(i); 	
	}
	public static double cos(double i)
	{
		return Math.cos(i); 	
	}
	public static double tan(double i)
	{
		return Math.tan(i); 	
	}
	public static String var()
	{
		if(!l.isEmpty())
		{
			String tmp="{";
			for(Type t:l)
			{
				tmp+= t.name+':';
				tmp+=String.format("%-10.4f ,",t.data);
			}
			tmp+="}";
			return tmp;
		}
		else
		{
			return "{ }";
		}
	}
	public static void clear()
	{
		l.clear();
	}
	public static String[] parseNext(String str)
	{
		String output  =new String("");
		char[] hold = str.toCharArray();
		for(int i =0; hold[i]!=' ';i++)
		{
		  output+=hold[i];
		}
		str=str.substring(output.length()+1);
		String[]temp={str,output};
		return temp;
	}
	public static String[] parseLine(String str)
	{
		LinkedList<String> list = new LinkedList<String>();
		String tmp=str;
		while(!tmp.equals(""))
		{
			list.add(parseNext(tmp)[1]);
			tmp=parseNext(tmp)[0];
		}
		String[] arr=new String[list.size()];
		return list.toArray(arr);
	}	
	
}
class CountException extends Exception
{	
}
class UnknownVariableException extends Exception
{
}


