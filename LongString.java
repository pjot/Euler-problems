public class LongString {
	
	private int maxLength = 1000000;
	
	public LongString()
	{
		String s = "";
		int i = 1, stringLength = 0;
		while (stringLength <= this.maxLength)
		{
			stringLength += String.valueOf(i).length();
			if (i % 10000 == 0) {
				System.out.println(i + ": length = " + stringLength);
			}
			s += i;
			i++;
			
		}
		int product = 1;
		for (int j = 1; j <= this.maxLength; j *= 10)
		{
			product *= Character.getNumericValue(s.charAt(j-1));
		}
		System.out.println("Product: " + product);
	}
	
	public static void main(String[] args)
	{
		new LongString();
	}
}
