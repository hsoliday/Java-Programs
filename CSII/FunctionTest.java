
public class FunctionTest 
{
	public static double findRoot(double a, double b, double eps)
	{
		double midPoint=(a+b)/2;
		if(abs(a-midPoint)<eps)
		{
			return midPoint;
		}
		else if(isNeg(sqrt(a))==isNeg(sqrt(midPoint)))
		{
			return findRoot(midPoint,b,eps);
		}
		else
		{
			return findRoot(a,midPoint,eps);
		}	
	}
	public static double abs(double d)//added all these extra methods for easy porting to BigDecimal
	{
		return Math.abs(d);
	}
	public static boolean isNeg(double d)
	{
		if(Math.signum(d)>0)
		{
			return false;
		}
		return true;
	}
	public static double sqrt(double d)
	{
		try {
			return Math.sqrt(d);
		}
		catch(Exception e)// catches for numbers less than 0, couldn't figure out what exception, but this catches all
		{
			return -1;
		}
		
	}
}
