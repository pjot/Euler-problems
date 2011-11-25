import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Euler problem 10
 *
 * @author pjot
 */
public class FourGrid {
    
    private class Matrix {
        private List<List> rows = new ArrayList<List>();
        private int currentX = 0;
        private int currentY = 0;
        
        public void addRow(List<Integer> row)
        {
            this.rows.add(row);
        }
        
        public int get()
        {
            List<Integer> row = this.rows.get(currentY);
            return row.get(currentX);
        }
        
        public Matrix move(int moveX, int moveY)
        {
            this.currentX += moveX;
            this.currentY += moveY;
            return this;
        }
        
        public Matrix set(int x, int y)
        {
            this.currentX = x;
            this.currentY = y;
            return this;
        }
        
        public int getSize()
        {
            return rows.size();
        }
    }
    
    private Matrix getMatrix()
    {
        Matrix matrix = new Matrix();
        
        File file = new File("p10.txt");
        try {
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                List<Integer> row = new ArrayList<Integer>();
                for (String i : line.split(" "))
                {
                    int number = Integer.valueOf(i);
                    row.add(number);
                }
                matrix.addRow(row);
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
        return matrix;        
    }
    
    public FourGrid()
    {
        Matrix matrix = this.getMatrix();
        int matrixSize = matrix.getSize();
        int largestSum = 0;
        
        for (int x = 0; x < matrixSize; x++)
        {
            for (int y = 0; y < matrixSize; y++)
            {
                int i, sum;
                matrix.set(x, y);
                
                if (x + 4 <= matrixSize) {
                    // Check to the right
                    sum = matrix.get();
                    System.out.println("M1: " + matrix.get());
                    for (i = x; i < 3; i++)
                    {
                        matrix.move(1, 0);
                        System.out.println("M1: " + matrix.get());
                        sum *= matrix.get();
                    }
                    if (sum > largestSum) {
                        largestSum = sum;
                    }
                    matrix.set(x, y);
                }
                
                if (y + 4 <= matrixSize) {
                    // Check down
                    sum = matrix.get();
                    System.out.println("M2: " + matrix.get());
                    for (i = x; i < 3; i++)
                    {
                        matrix.move(0, 1);
                        System.out.println("M2: " + matrix.get());
                        sum *= matrix.get();
                    }
                    if (sum > largestSum) {
                        largestSum = sum;
                    }
                    matrix.set(x, y);
                }
                
                if (x + 4 <= matrixSize && y + 4 < matrixSize) {
                    // Check downright
                    sum = matrix.get();
                    System.out.println("M3: " + matrix.get());
                    for (i = x; i < 3; i++)
                    {
                        matrix.move(1, 1);
                        System.out.println("M3: " + matrix.get());
                        sum *= matrix.get();
                    }
                    if (sum > largestSum) {
                        largestSum = sum;
                    }
                    matrix.set(x, y);
                }
                
                if (x >= 4 && y + 4 <= matrixSize) {
                    // Check downleft
                    sum = matrix.get();
                    System.out.println("M4: " + matrix.get());
                    for (i = x; i < 3; i++)
                    {
                        matrix.move(-1, 1);
                        System.out.println("M4: " + matrix.get());
                        sum *= matrix.get();
                    }
                    if (sum > largestSum) {
                        largestSum = sum;
                    }
                }
            }
        }
        System.out.println(largestSum);
    }
    
    public static void main(String[] args)
    {
        new FourGrid();
    }
}