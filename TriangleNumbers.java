import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TriangleNumbers {

	private long currentTriangle = 0;
	private long triangleNumber = 0;
	private int numberOfDivisors = 0;
		
	public TriangleNumbers()
	{
		List<Long> factors = new ArrayList<Long>();
		List<Long> combinedFactors = new ArrayList<Long>();
		int currentNumberOfDivisors = 0;
		
		while ((currentNumberOfDivisors = combinedFactors.size()) < 500)
		{
			if (currentNumberOfDivisors > this.numberOfDivisors) {
				this.numberOfDivisors = currentNumberOfDivisors;
			}
			
			long triangleNumber = this.getNextTriangleNumber();
			factors = this.getFactors(triangleNumber);
			combinedFactors = this.combineFactors(factors);
			combinedFactors.add(new Long(1));
			combinedFactors.add(triangleNumber);
			combinedFactors = new ArrayList<Long>(new HashSet<Long>(combinedFactors));
			Collections.sort(combinedFactors);
		}
		System.out.println("Done! Triangle number #" + this.currentTriangle + ": " + this.triangleNumber);
		System.out.println("Highest number of divisors: " + currentNumberOfDivisors);
	}
	
	public static void main(String[] args)
	{
		new TriangleNumbers();
	}
	
	public long getNextTriangleNumber()
	{
		this.currentTriangle++;
		this.triangleNumber += this.currentTriangle;
		return this.triangleNumber;
	}
		
	public List<Long> getFactors(long number)
	{
		List<Long> factors = this.getPrimeFactors(number);
		Collections.sort(factors);
		return factors;
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
	
	private List<Long> getPrimeFactors(long i)
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
