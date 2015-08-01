
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
}
