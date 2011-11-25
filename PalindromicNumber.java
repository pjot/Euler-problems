/**
 * Euler problem 4
 * 
 * @author pjot
 */
public class PalindromicNumber {
	
	public PalindromicNumber()
	{
		int biggestPalindrome = 0,
			biggestI = 0,
			biggestJ = 0;
		
		for (int i = 100; i < 1000; i++)
		{
			for (int j = 100; j < 1000; j++)
			{
				int tmp = i * j;
				if (isPalindrome(tmp)) {
					if (tmp > biggestPalindrome) {
						biggestPalindrome = tmp;
						biggestI = i;
						biggestJ = j;
					}
				}
			}
		}
		
		System.out.print("Biggest palindrome: ");
		System.out.print(biggestPalindrome);
		System.out.print(" = ");
		System.out.print(biggestI);
		System.out.print(" x ");
		System.out.print(biggestJ);
	}
	
	private boolean isPalindrome(int number)
	{
		int originalNumber = number,
			reversedNumber = 0,
			tmp = 0;
		
		while (number > 0)
		{
			tmp = number % 10;
			reversedNumber = reversedNumber * 10 + tmp;
			number /= 10;
		}

		return originalNumber == reversedNumber;
	}
	
	public static void main(String[] args)
	{
		new PalindromicNumber();
	}
}
