
package babysitterkata;


public class EveningOfBabySitting {
    
    public boolean setStartTime(int hour, int minutes)
    {
        if(hour < 17 && hour > 3)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean setEndTime(int hour, int minutes)
    {
        if(hour < 17 && hour > 4)
        {
            return false;
        }
        else if(hour == 4 && minutes > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
