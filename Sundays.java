import java.util.Calendar;

public class Sundays {
    public static void main(String[] args)
    {
        int sundays = 0;
        Calendar date = Calendar.getInstance();
        date.set(1901, 0, 1);
        
        while (date.get(Calendar.YEAR) < 2001)
        {
            if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                sundays++;
            }
            date.add(Calendar.MONTH, 1);
        }
        
        System.out.println("Sundays: " + sundays);
    }
}
