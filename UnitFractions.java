import java.util.ArrayList;

public class UnitFractions {
    
    private ArrayList<Double> decimals = new ArrayList<Double>();
    public UnitFractions()
    {
        for (int i = 1; i <= 1000; i++)
        {
            this.decimals.add((double) 1 / i);
        }
        System.out.print(this.decimals);
    }
    
    public static void main(String[] args)
    {
        new UnitFractions();
    }
}
