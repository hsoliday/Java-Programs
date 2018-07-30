
public class Ramanujan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static double pi(int n )
	{
		double sigmaValue=0.0;
		for(int i = 0;i<=n;i++)
		{
			sigmaValue+=(Factorial.calculate(4*i)*(1103+26390*i))/(Math.pow(Factorial.calculate(i), 4)*Math.pow(396, 4*i));
		}
		double invPi=sigmaValue*((2*Math.sqrt(2))/9801);
		return Math.pow(invPi, -1);
	}

}
