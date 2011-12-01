public class SumFifthPowers {
    public static void main(String[] args)
    {
        int sum = 0, power = 5, found = 0;
        for (long i = 2; i < 1000000; i++)
        {
            long squareSum = 0, j = i;
            while (j > 0)
            {
                long k = j % 10;
                squareSum += (long) Math.pow(k, power);
                j /= 10;
            }
            if (squareSum == i) {
                sum += squareSum;
                found++;
            }
        }
        System.out.println("Sum: " + sum + " (" + found + " found)");
    }
}
