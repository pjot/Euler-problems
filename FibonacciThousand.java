import java.math.BigInteger;


public class FibonacciThousand {

	public FibonacciThousand()
	{
		BigInteger currentFib = BigInteger.ONE;
		BigInteger previousFib = BigInteger.ONE;

		int i = 2;
		while (currentFib.toString().length() < 1000)
		{
			BigInteger tmpFib = currentFib;
			currentFib = currentFib.add(previousFib);
			previousFib = tmpFib;
			i++;
		}
		System.out.println("First fibonacci: #" + i);
		
	}
	
	public static void main(String[] args)
	{
		new FibonacciThousand();
	}
}
