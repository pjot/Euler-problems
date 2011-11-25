import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Euler problem 5
 * 
 * @author pjot
 */
public class LowestDivisor {
	List<Integer> primeParts = new ArrayList<Integer>();
	
	public LowestDivisor()
	{
		for (int i = 2; i <= 20; i++)
		{
			List<Integer> primes = PrimeFactor.getFactors(i),
						  tmpPrimeParts = new ArrayList<Integer>();
			
			tmpPrimeParts.addAll(primeParts);
			for (int j : primes)
			{
				if (tmpPrimeParts.contains(j)) {
					tmpPrimeParts.remove(tmpPrimeParts.indexOf(j));
				} else {
					primeParts.add(j);
				}
			}
		}
		Collections.sort(primeParts);
		System.out.print("Primes: ");
		System.out.println(primeParts);
		System.out.print("Product: ");
		int product = 1;
		for (int primePart : primeParts)
		{
			product *= primePart;
		}
		System.out.println(product);
	}
	
	public static void main(String[] args)
	{
		new LowestDivisor();
	}
}
