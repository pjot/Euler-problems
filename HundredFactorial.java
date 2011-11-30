import java.math.BigInteger;


public class HundredFactorial {
	
	public HundredFactorial()
	{
		BigInteger n = BigInteger.ONE;
		for (int i = 1; i < 101; i++)
		{
			n = n.multiply(BigInteger.valueOf(i));
		}
		int sum = 0;
		for (char number : n.toString().toCharArray())
        {
                sum += Character.getNumericValue(number);
        }
		System.out.println("The sum of the digits in 100! is: " + sum);
	}
	
	public static void main(String[] args)
	{
		new HundredFactorial();
	}

}
