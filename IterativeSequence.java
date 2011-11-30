import java.util.ArrayList;

public class IterativeSequence {
    
    private long maxValue = 1000000;
    
    public static void main(String[] args)
    {
        new IterativeSequence();
    }
    
    public IterativeSequence()
    {
        ArrayList<Long> lengths = new ArrayList<Long>();
        long zero = new Long(0);
        for (int i = 0; i <= this.maxValue; i++)
        {
            lengths.add(zero);
        }
        
        for (int i = 1; i <= this.maxValue; i++)
        {
            if (i % 100000 == 0) {
                System.out.println(i);
            }
            long iterations = 2;
            long n = i;
            while ((n = iterate(n)) != 1)
            {
                iterations++;
                if (Long.valueOf(n).intValue() > 0) {
                    if (n < (long)lengths.size() && lengths.get((int)n) != zero)
                    {
                        iterations = iterations + lengths.get((int)n);
                        break;
                    }
                }
            }
            lengths.set(i, iterations);
        }
        lengths.remove(0);
        
        long maxNumber = 0,
             maxCount = 0;
        for (int i = 0; i < maxValue; i++)
        {
            if (lengths.get(i) > maxCount) {
                maxCount = lengths.get(i);
                maxNumber = i + 1;
            }
        }
        System.out.println(maxNumber + " has " + maxCount + " iterations.");
    
    }
    
    private long iterate(long i)
    {
        return i % 2 == 0
                ? i / 2 
                : 3 * i + 1;
    }
}
