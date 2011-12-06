import java.util.HashMap;
import java.math.BigInteger;

public class Combinations {
    
    private int maxValue = 100;
    private HashMap<Integer, BigInteger> factorials = new HashMap<Integer, BigInteger>();
    private BigInteger oneMillion = BigInteger.valueOf(1000000);
    private int combinations = 0;
    
    public static void main(String[] args)
    {
        new Combinations();
    }
    
    public Combinations()
    {
        this.generateFactorials(this.maxValue);
        
        for (int n = 1; n <= this.maxValue; n++)
        {
            for (int r = 1; r <= n; r++)
            {
                if (this.getCombinations(n, r).compareTo(this.oneMillion) == 1)
                {
                    this.combinations++;
                }
            }
        }
        
        System.out.println("Combinations: " + this.combinations);
    }
    
    private BigInteger getCombinations(int n, int r)
    {
        BigInteger nom = this.getFactorial(n);
        BigInteger deNom = this.getFactorial(r).multiply(this.getFactorial(n - r));
        return nom.divide(deNom);
    }
    
    private void generateFactorials(int max)
    {
        this.factorials.put(0, BigInteger.ONE);
        for (int i = 1; i <= max; i++)
        {
            BigInteger prevValue = this.factorials.get(i - 1);
            BigInteger currentI = BigInteger.valueOf(i);
            this.factorials.put(i, currentI.multiply(prevValue));
        }
    }
    
    private BigInteger getFactorial(int i)
    {
        return this.factorials.get(i);
    }
}
