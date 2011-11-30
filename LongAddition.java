import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LongAddition {

	public static void main(String[] args) {
		new LongAddition();
	}
	
	public LongAddition()
	{
		List<String> numbers = new ArrayList<String>();
		numbers = this.getNumbers();
		int carry = 0;
		String result = "";
		for (int i = numbers.get(0).length() - 1; i >= 0; i--)
		{
			int sum = carry;
			for (String number : numbers)
			{
				sum += Character.getNumericValue(number.charAt(i));
			}
			result = sum % 10 + result;
			carry = (int) Math.floor(sum / 10);
		}
		result = carry + result;
		System.out.println(result.substring(0, 10));
	}
	
	public List<String> getNumbers()
	{
		File file = new File("/home/pjot/workspace/Euler/src/longadd.txt");
		List<String> numbers = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine())
            {
                numbers.add(scanner.nextLine());
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return numbers;
	}

}
