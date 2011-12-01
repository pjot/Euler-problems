import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AbundantNumbers {

	public AbundantNumbers()
	{
		ArrayList<Long> abundantNumbers = new ArrayList<Long>();
		for (long i = 10; i < 28124; i++)
		{
			if (getDivisorSum(i) > i) {
				abundantNumbers.add(i);
			}
		}
		HashSet<Long> sums = getPairwiseSums(abundantNumbers);
		long sum = 0;
		for (long i = 1; i < 28124; i++)
		{
			if ( ! sums.contains(new Long(i))) {
				sum += i;
			}
		}
		System.out.println("Sum: " + sum);
	}
	
	public static void main(String[] args)
	{
		new AbundantNumbers();
	}

	public HashSet<Long> getPairwiseSums(ArrayList<Long> numbers)
	{
		HashSet<Long> sums = new HashSet<Long>();
		
		while (true)
		{
			if (numbers.size() == 1) {
				break;
			}
			long i = numbers.get(0);
			for (long j : numbers)
			{
				sums.add(i + j);
			}
			numbers.remove(0);
		}
		return sums;
	}
	    
	public long getDivisorSum(long i)
	{
		List<Long> factors = combineFactors(getPrimeFactors(i));
		factors.add(new Long(1));
		factors.remove(i);
		if (factors.size() == 0) {
			return 0;
		}
		long sum = 0;
		for (long n : factors)
		{
			sum += n;
		}
		return sum;
	}
	
	public List<Long> combineFactors(List<Long> factors)
	{
		List<Long> combinedFactors = new ArrayList<Long>();
		int n = Double.valueOf(Math.pow(2, factors.size())).intValue();
		for (int i = 1; i < n; i++)
		{
			String binary = Integer.toBinaryString(i);
			while (binary.length() < factors.size())
			{
				binary = "0" + binary;
			}

			long currentCombination = 1;
			for (int j = 0; j < binary.length(); j++)
			{
				if (Character.getNumericValue(binary.charAt(j)) == 1) {
					currentCombination *= factors.get(j);
				}
			}
			if ( ! combinedFactors.contains(currentCombination)) {
				combinedFactors.add(currentCombination);
			}
		}
		return combinedFactors;
	}
	
	public List<Long> getPrimeFactors(long i)
	{
		long factor = 3;
		List<Long> factors = new ArrayList<Long>();
		// Check if 2 is a prime factor
		while (i % 2 == 0)
		{
			factors.add(new Long(2));
			i /= 2;
		}
		
		long maxFactor = Math.round(Math.sqrt(i) + 1);
		while (factor <= maxFactor && i > 1)
		{
			if (i % factor == 0)
			{
				factors.add(factor);
				i /= factor;
				while (i % factor == 0)
				{
					factors.add(factor);
					i /= factor;
				}
				maxFactor = Math.round(Math.sqrt(i));
			}
			factor += 2;
		}
		if (i != 1) {
			factors.add(i);
		}
		return factors;		
	}
}
