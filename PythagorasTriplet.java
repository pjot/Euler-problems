/**
 * Euler problem 9
 * 
 * @author pjot
 */
public class PythagorasTriplet {

	public PythagorasTriplet()
	{
		for (int a = 3; a < 1000; a++)
		{
			for (int b = 4; b < 1000; b++)
			{
				double sum = Math.pow(a, 2) + Math.pow(b, 2);
				double c = Math.sqrt(sum);
				if (a + b + c == 1000) {
					System.out.println("a = " + a + ", b = " + b + ", c = " + (int)c);
					int product = a * b * (int)c;
					System.out.println(product);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		new PythagorasTriplet();
	}
}
