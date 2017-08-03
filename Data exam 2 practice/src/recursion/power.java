package recursion;

public class power
{

	public static double power(double base, int exponent)
	{
		if(exponent==0)
			return 1.0;
		else
		{
			return base*power(base, exponent-1);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(power(4.0,2));
	}
	
}
