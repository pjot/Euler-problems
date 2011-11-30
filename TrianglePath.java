import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TrianglePath {

	public TrianglePath()
	{
		ArrayList<ArrayList<Integer>> triangle = getTriangle();
		int maxPath = 0, i = triangle.size() - 1;
		while (true)
		{
			ArrayList<Integer> row = triangle.get(i);
			ArrayList<Integer> nextRow = triangle.get(i - 1);
			for (int n = 1; n < row.size(); n++)
			{
				int biggest = row.get(n) > row.get(n - 1) ? row.get(n) : row.get(n - 1);				
				nextRow.set(n - 1, nextRow.get(n - 1) + biggest);				
			}
			if (nextRow.size() == 1) {
				maxPath = nextRow.get(0);
				break;
			}
			i--;
		}
		System.out.println("Maximal sum: " + maxPath);
	}

	public static void main(String[] args)
	{
		new TrianglePath();
		
	}

    public ArrayList<ArrayList<Integer>> getTriangle()
    {
        File file = new File("/home/pjot/workspace/Euler/src/triangle.txt");
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
            	String line = scanner.nextLine();
                ArrayList<Integer> row = new ArrayList<Integer>();
                for (String i : line.split(" "))
                {
                    row.add(Integer.valueOf(i));
                }
            	triangle.add(row);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return triangle;
    }
}
