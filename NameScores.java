import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class NameScores {

	public HashMap<Character, Long> scores = new HashMap<Character, Long>();
	
	public NameScores()
	{
		generateAlphabetList();
		ArrayList<String> names = new ArrayList<String>();
		
		File file = new File("/home/pjot/workspace/Euler/src/names.txt");
        try {
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine())
            {
                names.add(scanner.nextLine());
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
        Collections.sort(names);
        
        int namesSize = names.size();
        long totalScore = 0;
        for (int i = 0; i < namesSize; i++)
        {
        	long score = 0;
        	for (char c : names.get(i).toCharArray())
        	{
        		score += scores.get(c);
        	}
        	score *= (i + 1);
        	totalScore += score;
        }
        System.out.println("Total score: " + totalScore);        
	}
	
	public void generateAlphabetList()
	{
		scores.put(new Character('A'), new Long(1));
		scores.put(new Character('B'), new Long(2));
		scores.put(new Character('C'), new Long(3));
		scores.put(new Character('D'), new Long(4));
		scores.put(new Character('E'), new Long(5));
		scores.put(new Character('F'), new Long(6));
		scores.put(new Character('G'), new Long(7));
		scores.put(new Character('H'), new Long(8));
		scores.put(new Character('I'), new Long(9));
		scores.put(new Character('J'), new Long(10));
		scores.put(new Character('K'), new Long(11));
		scores.put(new Character('L'), new Long(12));
		scores.put(new Character('M'), new Long(13));
		scores.put(new Character('N'), new Long(14));
		scores.put(new Character('O'), new Long(15));
		scores.put(new Character('P'), new Long(16));
		scores.put(new Character('Q'), new Long(17));
		scores.put(new Character('R'), new Long(18));
		scores.put(new Character('S'), new Long(19));
		scores.put(new Character('T'), new Long(20));
		scores.put(new Character('U'), new Long(21));
		scores.put(new Character('V'), new Long(22));
		scores.put(new Character('W'), new Long(23));
		scores.put(new Character('X'), new Long(24));
		scores.put(new Character('Y'), new Long(25));
		scores.put(new Character('Z'), new Long(26));
	}
	
	public static void main(String[] args)
	{
		new NameScores();
	}

}
