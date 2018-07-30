
public class Factorial {

	public static void main(String[] args) 
	{
		boolean test=false;// if ran without args, it runs in "test mode"
		if(args.length<1)
		{
			test = true;
		}
		if(!test)
		{
			long l=calculate((long)Integer.parseInt(args[0]));
			if(l!=-1)
				System.out.println(l);
			else
				System.out.println("error, number outside of range");
			return;
		}
		System.out.print("Factorial.calculate(0) returned"+calculate(0));
		if(calculate(0)==1)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println(" Test Failed");
			return;
		}
		System.out.print("Factorial.calculate(40) returned"+calculate(40));
		if(calculate(40)==-1)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println(" Test Failed");
			return;
		}
		System.out.print("Factorial.calculate(-15) returned"+calculate(-15));
		if(calculate(-15)==-1)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println(" Test Failed");
			return;
		}
		System.out.println("Factorial.calculate(6) returned"+calculate(6));
		if(calculate(6)==720)// runs a test of 6
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println(" Test Failed");
			return;
		}
	}
	public static long calculate(long n)// recursive solution to find factorials
	{
		if(n>20||n<1)// returns -1 if the n is out 
		{
			return -1;
		}
		if(n==0)// accounts for the special case zero
		{
			return 1;
		}
		else 
		{
			return n*calculate(n-1);
		}
	}

}
