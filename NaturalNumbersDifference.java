import java.math.BigInteger;

/**
 * Euler problem 6
 * 
 * @author pjot
 */
public class NaturalNumbersDifference {

	public NaturalNumbersDifference()
	{
		BigInteger sumOfSquares = BigInteger.ZERO,
				   squareOfSums = BigInteger.ZERO,
				   sum = BigInteger.ZERO,
				   difference = BigInteger.ZERO;
		
		for (int i = 1; i <= 100; i++)
		{
			BigInteger bigI = BigInteger.valueOf(i);
			sum = sum.add(bigI);
			sumOfSquares = sumOfSquares.add(bigI.pow(2));
		}
		
		squareOfSums = sum.pow(2);
		difference = squareOfSums.subtract(sumOfSquares);
		System.out.print("The difference is: ");
		System.out.print(squareOfSums);
		System.out.print(" - ");
		System.out.print(sumOfSquares);
		System.out.print(" = ");
		System.out.print(difference);
	}
	
	public static void main(String[] args)
	{
		new NaturalNumbersDifference();
	}
}
