
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
        if(hour == 5)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
