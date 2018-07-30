
public class Poly 
{
	private int[] coefficients;
	public Poly()
	{
		coefficients= new int[1];
		coefficients[0]=0;
	}
	public Poly(int[] coefficients)
	{
		this.coefficients=coefficients;
	}
	public int degree()
	{
		int deg = 0;
		for(int i=coefficients.length-1;i>=0;i++)
		{
			if(coefficients[i]>0)
			{
				deg=i;
				break;
			}
		}
		return deg;
	}
	public String toString()
	{
		String tmp="";
		for(int i=coefficients.length-1;i>=0;i++)
		{
			if(coefficients[i]!=0)
			{
				if(coefficients[i]>0)
				{
					tmp+="+";
				}
					tmp+=coefficients[i]+"x^"+(i-1);
			}
		}
		return tmp;
	}
	public double evaluate(double d)
	{
		double tmp=0;
		for(int i=coefficients.length-1;i>=0;i++)
		{
			tmp+=Math.pow(d, i)*coefficients[i];
		}
		return tmp;
	}
}
