import java.util.ArrayList;

public class TwentyGrid {
    
    private int gridSize = 20;
    private ArrayList<Long> currentPascalRow = new ArrayList<Long>();
    
    public static void main(String[] args)
    {
        new TwentyGrid();
    }
    
    public TwentyGrid()
    {
        this.currentPascalRow.add(new Long(1));
        System.out.println("Calculating routes for a " + this.gridSize + "x" + this.gridSize + " grid...");
        for (int i = 0; i < this.gridSize; i++)
        {
            this.currentPascalRow = this.getNextPascalRow();
            this.currentPascalRow = this.getNextPascalRow();
        }
        long routes = this.currentPascalRow.get(this.currentPascalRow.size() / 2);
        System.out.println("Routes: " + routes);
    }
    
    private ArrayList<Long> getNextPascalRow()
    {
        int currentPascalRowSize = this.currentPascalRow.size();
        ArrayList<Long> nextRow = new ArrayList<Long>();
        nextRow.add(new Long(1));
        for (int i = 1; i < currentPascalRowSize; i++)
        {
            nextRow.add(this.currentPascalRow.get(i - 1) + this.currentPascalRow.get(i));
        }
        nextRow.add(new Long(1));
        
        return nextRow;
    }
}
