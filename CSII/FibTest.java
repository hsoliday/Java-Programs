public class FibTest 
{
	public static void main(String[] args)
	{
		boolean test=false;// if ran without args, it runs in "test mode"
		if(args.length<1)
		{
			test = true;
		}
		if(!test)
		{
			System.out.println(iterFib(Integer.parseInt(args[0])));
			return;
		}
		System.out.print("FibTest.iterFib(0) returned"+iterFib(0));
		if(iterFib(0)==1)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		System.out.print("FibTest.iterFib(40) returned"+iterFib(40));
		if(iterFib(40)==102334155)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		System.out.print("FibTest.recurFib(0) returned"+recurFib(0));
		if(recurFib(0)==1)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		System.out.print("FibTest.recurFib(40) returned"+recurFib(40));
		if(recurFib(40)==102334155)
		{
			System.out.println(" Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		long j = System.currentTimeMillis();
		recurFib(40);
		System.out.print("FibTest.recurFib(40) took"+(System.currentTimeMillis()-j));
		j = System.currentTimeMillis();
		iterFib(40);
		System.out.print("FibTest.iterFib(40) took"+(System.currentTimeMillis()-j));
		
	}
	public static int iterFib(int i )
	{
	int prevNumber=0;
	int currentNumber = 1;
	int temp;
	int count = 1;
	do
	{
		//iterates through one set of fibonacci numbers
		temp = currentNumber;
		currentNumber = prevNumber + currentNumber;
		prevNumber=temp;
		count++;// then increases the count
	}while(count<i);// checks to see if this has counted through enough fibonacci numbers;
	return currentNumber;
}
	public static int recurFib(int i)
	{
		if(i<3)
		{
			return 1;
		}
		else
		{
			return recurFib(i-1)+recurFib(i-2);
		}
	}
}
