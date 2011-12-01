import java.util.HashMap;
public class FactorialSum {
    public static void main(String[] args)
    {
//        long fNine = 9*8*7*6*5*4*3*2;
//        System.out.println("Factorial of nine: " + fNine);
//        for (long i = 1; i < 20; i++)
//        {
//            long number = fNine * i;
//            System.out.println(number);
//            for (long j = 0; j < i; j++)
//            {
//                System.out.print("#");
//            }
//            System.out.print(" " + i);
//            System.out.println();
//        }
        HashMap<Long, Long> factorials = new HashMap<Long, Long>();
        for (long i = 1; i < 10; i++)
        {
            factorials.put(new Long(0), new Long(1));
            long factorial = 1;
            for (long j = i; j > 1; j--)
            {
                factorial *= j;
            }
            factorials.put(i, factorial);
        }
        
        long sum = 0, found = 0;
        for (long i = 10; i < 1000000; i++)
        {
            long squareSum = 0, j = i;
            while (j > 0)
            {
                long k = j % 10;
                squareSum += factorials.get(k);
                j /= 10;
            }
            if (squareSum == i) {
                System.out.println("Adding " + i);
                sum += squareSum;
                found++;
            }
        }
        System.out.println("Found " + found + " number. Sum: " + sum);
    }
}
