import java.util.ArrayList;
import java.util.List;

/**
 * Euler problem 7
 * 
 * @author pjot
 */
public class PrimeFinder {

	private List<Integer> primes = new ArrayList<Integer>();
	private int maxNumber = 10001;
	
	public PrimeFinder()
	{
		primes.add(2);
		int i = 3;
		while (primes.size() < maxNumber)
		{
			if (isPrime(i)) {
				primes.add(i);
			}
			// All even numbers are non-primes except 2 so we only have to check the odd ones
			i += 2;
		}
		System.out.println("Prime #" + primes.size() + ":");
		System.out.println(primes.get(primes.size() - 1));
	}
	
	private boolean isPrime(int number)
	{
		for (int prime : primes)
		{
			if (number % prime == 0) {
				return false;
			} else if (Math.sqrt(number) < prime) {
				return true;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		new PrimeFinder();
	}
}
