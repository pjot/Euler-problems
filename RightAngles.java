import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Solves Euler Problem 39
public class RightAngles {
    // Maximum p
    private int max = 1000;
    // Using a HashSet to prevent duplicates.
    private HashSet<Triplet> pythagorasTriplets = new HashSet<Triplet>();
    
    // Constructor
    public RightAngles()
    {
        // Find all Pythagoras triplets with a hypotenuse < this.max / 2 and
        this.max /= 2;
        for (int c = 5; c < this.max; c++)
        {
            for (int a = c - 1; a > 0; a--)
            {
                if (a == 1) {
                    break;
                }
                double b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
                if (Math.floor(b) == b)
                {
                    this.pythagorasTriplets.add(new Triplet(a, (int) b, c));
                }
            }
        }
        // Add the sums to a custom HashMap
        CountMap<Integer, Integer> tripletSums = 
                new CountMap<Integer, Integer>();
        for (Triplet triplet : this.pythagorasTriplets)
        {
            tripletSums.increase(triplet.sum());
        }
        // Done!
        System.out.print("Maximum of " + tripletSums.getMaxSum());
        System.out.println(" for " + tripletSums.getMax());
        
    }
    
    // Custom HashMap class that keeps track of the highest value and its key.
    // This class also adds a increase() method.
    private class CountMap<K, V> extends HashMap {
        private int max, maxSum = 0;
        // Add the key if it doesn't exist, then add one to the value it.
        public void increase(Integer k)
        {
            int sum = 1;
            if (this.containsKey(k))
            {
                Object y = this.get(k);
                if (y instanceof Integer)
                {
                    Integer i = (Integer) y;
                    sum += i.intValue();
                }
            }
            this.put(k, sum);
        }
        // Keep track of the maximum sums as well as storing this set.
        public Object put(Integer k, Integer v)
        {
            if (v > this.maxSum)
            {
                this.maxSum = v;
                this.max = k;
            }
            return super.put(k, v);
        }
        // Get max value
        public int getMax()
        {
            return this.max;
        }
        // Get max value's sum (p)
        public int getMaxSum()
        {
            return this.maxSum;
        }
    }
    
    // Custom ArrayList that is able to return its sum.
    private class Triplet extends ArrayList {
        private int a, b, c, sum = 0;
        
        // Constructor
        public Triplet(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.add(c);
            this.add(a > b ? a : b);
            this.add(a > b ? b : a);
        }
        // Get the sum
        public Integer sum()
        {
            if (this.sum == 0)
            {
                this.sum = this.a + this.b + this.c;
            }
            return this.sum;
        }
    } 
    
    // Main action, run constructor
    public static void main(String[] args)
    {
        new RightAngles();
    }
}
