import java.util.HashMap;

public class LetterCount {
    private int max = 1000;
    private HashMap<Integer, Integer> digitValues = 
            new HashMap<Integer, Integer>();
    
    public LetterCount()
    {
       this.setUp();
       int count = 0;
       for (int i = 1; i <= this.max; i++)
       {
           count += this.getCount(i);
       }
       System.out.println("Length: " + count);
       
    }
    
    private void setUp()
    { 
        this.digitValues.put(0, 0);
        this.digitValues.put(1, 3);
        this.digitValues.put(2, 3);
        this.digitValues.put(3, 5);
        this.digitValues.put(4, 4);
        this.digitValues.put(5, 4);
        this.digitValues.put(6, 3);
        this.digitValues.put(7, 5);
        this.digitValues.put(8, 5);
        this.digitValues.put(9, 4);
        this.digitValues.put(10, 3);
        this.digitValues.put(11, 6);
        this.digitValues.put(12, 6);
        this.digitValues.put(13, 8);
        this.digitValues.put(14, 8);
        this.digitValues.put(15, 7);
        this.digitValues.put(16, 7);
        this.digitValues.put(17, 9);
        this.digitValues.put(18, 8);
        this.digitValues.put(19, 8);
        this.digitValues.put(20, 6);
        this.digitValues.put(30, 6);
        this.digitValues.put(40, 5);
        this.digitValues.put(50, 5);
        this.digitValues.put(60, 5);
        this.digitValues.put(70, 7);
        this.digitValues.put(80, 6);
        this.digitValues.put(90, 6);
        this.digitValues.put(100, 7);
        this.digitValues.put(1000, 8);
    }
    
    private int getCount(int i)
    {
        if (i < 20) {
            return this.digitValues.get(i);
        }
        
        if (i < 100) {
            return this.digitValues.get(i - (i % 10)) + this.getCount(i % 10);
        }
        
        if (i > 99 && i < 1000) {
            return this.digitValues.get((i - (i % 100)) / 100) + this.digitValues.get(100) + ((i % 100 != 0) ? 3 + this.getCount(i % 100) : 0);
        }
        return this.digitValues.get(1) + this.digitValues.get(1000);     
    }
    
    public static void main(String[] args)
    {
        new LetterCount();
    }
}
