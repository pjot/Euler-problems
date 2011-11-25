import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Euler problem 3
 * 
 * @author pjot
 */
public class PrimeFactor {
	
	public static List<Integer> getFactors(Integer i)
	{
		List<Integer> factorsNoBig = new ArrayList<Integer>();
		
		for (BigInteger bigInt : getFactors(BigInteger.valueOf(i)))
		{
			factorsNoBig.add(bigInt.intValue());
		}
		
		return factorsNoBig;
	}
	
	public static List<BigInteger> getFactors(BigInteger i)
	{		
		BigInteger startNumber = i,
				   factor = BigInteger.ZERO;
		List<BigInteger> factors = new ArrayList<BigInteger>();
		
		while ((factor = getFactor(startNumber)).compareTo(BigInteger.ZERO) != 0)
		{
			startNumber = startNumber.divide(factor);
			factors.add(factor);
		}
		
		factors.add(startNumber);
		
		return factors;
	}
	
	private static BigInteger getFactor(BigInteger n)
	{
		BigInteger i = BigInteger.valueOf(2);
		while (i.compareTo(n) < 0)
		{
			if (n.mod(i) == BigInteger.ZERO) {
				return i;
			}
			i = i.add(BigInteger.ONE);
		}
		return BigInteger.ZERO;
	}

	public static void main(String[] args)
	{
		String myNumber = "600851475143";
		BigInteger startNumber = new BigInteger(myNumber);
		List<BigInteger> factors = getFactors(startNumber);

		System.out.print("Number is: ");
		System.out.println(startNumber);
		
		System.out.print("Factors are: ");
		System.out.println(factors);
		
		System.out.print("Biggest factor is: ");
		System.out.println(factors.get(factors.size() - 1));
	}

}
