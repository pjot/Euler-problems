import java.util.HashSet;
import java.math.BigInteger;
public class DistinctSquares {
    public static void main(String[] args)
    {
        int max = 100;
        HashSet<BigInteger> numbers = new HashSet<BigInteger>();
        for (int a = max; a > 1; a--)
        {
            BigInteger c = BigInteger.valueOf(a);
            for (int b = max; b > 1; b--)
            {
                numbers.add(c.pow(b));
            }
        }
        System.out.println("Numbers: " + numbers.size());
    }
}
