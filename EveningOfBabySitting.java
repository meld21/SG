
package babysitterkata;


public class EveningOfBabySitting {
    
    private int startTimeHours = -1;
    private int startTimeMinutes = -1;
    private int endTimeHours = -1;
    private int endTimeMinutes = -1;
    
    public boolean setStartTime(int hour, int minutes)
    {
        if(hour < 17 && hour > 3)
        {
            return false;
        }
        else
        {
            this.startTimeHours = hour;
            this.startTimeMinutes = minutes;
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
            this.endTimeHours = hour;
            this.endTimeMinutes = minutes;
            return true;
        }
    }
    
    public boolean validWorkHoursEnter()
    {
        if(this.startTimeHours != -1 && this.endTimeHours != -1)
        {
            if(this.endTimeHours > 4)
            {
                if(this.endTimeHours > this.startTimeHours)
                {
                    return true;
                }
                if(this.endTimeHours == this.startTimeHours) 
                {
                    if((this.endTimeMinutes > this.startTimeMinutes))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(this.startTimeHours > 17)
                {
                    return true;
                }
                else
                {
                    if(this.startTimeHours < this.endTimeHours)
                    {
                        return true;
                    }
                    else
                    {
                        if(this.startTimeHours == this.endTimeHours)
                        {
                            if((this.endTimeMinutes > this.startTimeMinutes))
                            {
                                return true;
                            }                            
                        }
                    }
                }
            }    
    }
    
    return false;
}
    
}
