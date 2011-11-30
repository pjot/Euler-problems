import java.math.BigInteger;

public class PowerOfTwoSum {

    public PowerOfTwoSum()
    {
        BigInteger bigPower = BigInteger.valueOf(2).pow(1000);
        String bigNumber = bigPower.toString();
        int sum = 0;
        for (int i = 0; i < bigNumber.length(); i++)
        {
            sum += Character.getNumericValue(bigNumber.charAt(i));
        }
        System.out.println("Sum: " + sum);
    }
    
    public static void main(String[] args)
    {
        new PowerOfTwoSum();
    }
}
