public class SpiralDiagonals {
    public static void main(String[] args)
    {
        int i = 1, step = 2, diagonalSum = 1;
        while (step < 1001)
        {
            for (int j = 0; j < 4; j++)
            {
                i += step;
                diagonalSum += i;
            }
            step += 2;
        }
        System.out.println("Sum of numbers on diagonal: " + diagonalSum);
    }
}
