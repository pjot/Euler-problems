import java.math.BigInteger;

public class SumOfSquares {
    
    public SumOfSquares()
    {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++)
        {
            BigInteger currentSquare = BigInteger.valueOf(i);
            currentSquare = currentSquare.pow(i);
            sum = sum.add(currentSquare);
        }
        String sumString = sum.toString();
        System.out.println("Last 10 digits: " + sumString.substring(sumString.length() - 10));
        
    }
    
    public static void main(String[] args)
    {
        new SumOfSquares();
    }
}
